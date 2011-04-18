package vivian.jsash.kernal.net.http.client;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Requests;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.kernal.common.Responses;
import vivian.jsash.kernal.exception.ConverterException;
import vivian.jsash.kernal.net.config.NetworkConfig;
import vivian.jsash.kernal.util.XmlObjConverter;

public class NioHttpClient {

	private NioSocketConnector connector;
	private NetworkConfig config;
	private HttpClientHandler handler;
	private ConnectFuture cfuture;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public NioHttpClient() {
	}

	public void setConfig(NetworkConfig config) {
		this.config = config;
	}

	public NetworkConfig getConfig() {
		return config;
	}

	public void setHandler(HttpClientHandler handler) {
		this.handler = handler;
	}

	public HttpClientHandler getHandler() {
		return handler;
	}
	
	public Response sendRequest(Request request) {
		Requests requests = new Requests();
		List<Request> reqList = new ArrayList<Request>();
		reqList.add(request);
		requests.setRequests(reqList);
		Responses responses = sendRequests(requests);
		return responses.getResponses().get(0);
	}

	public Responses sendRequests(Requests requests) {
		try {
			XmlObjConverter converter = XmlObjConverter.getInstance();
			String context = converter.object2Xml(requests);
			IoSession session = createNioHttpClient();
//			HttpRequestMessage requestObj = new HttpRequestMessage();
//			requestObj.setContext(context);
			WriteFuture wf = session.write(context);
			wf.awaitUninterruptibly();
			
//			HttpClientHandler handler = (HttpClientHandler) session
//				.getHandler();
//			return handler.getResponses();

			ReadFuture readFuture = session.read();
			readFuture.awaitUninterruptibly();
			String resposeMsg = (String)readFuture.getMessage();
			Responses responses = (Responses) converter.xml2Object(resposeMsg);
			
			return responses;
		} catch (ConverterException e) {
			logger.error("Can not convert request object to XML.", e);
		}

		return null;
	}

	public IoSession createNioHttpClient() {
		// Create TCP/IP connector.
		connector = new NioSocketConnector();

		// Set connect timeout.
		connector.setConnectTimeoutMillis(config.getTimeout());

		// Start communication.
		connector.setHandler(new HttpClientHandler());

		TextLineCodecFactory factory = new TextLineCodecFactory();
		factory.setDecoderMaxLineLength(102400);
		factory.setEncoderMaxLineLength(10240);
		IoFilter CODEC_FILTER = new ProtocolCodecFilter(factory);
		connector.getFilterChain().addLast("codec", CODEC_FILTER);

		SocketSessionConfig cfg = connector.getSessionConfig();
		cfg.setUseReadOperation(true);

		cfuture = connector.connect(new InetSocketAddress(config.getDestUrl(),
				config.getDestPort()));

		logger.info("Client is connected to server " + config.getDestUrl()
				+ ":" + config.getDestPort());

		cfuture.awaitUninterruptibly();
		return cfuture.getSession();
	}

	public void shutdown() {
		cfuture.awaitUninterruptibly();
		cfuture.getSession().getCloseFuture().setClosed();
		cfuture.getSession().close(true);
		if (connector.isActive()) {
			connector.dispose();
		}
	}

}
