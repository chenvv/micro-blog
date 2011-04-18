package vivian.jsash.kernal.net.http.server;

import java.net.InetSocketAddress;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vivian.jsash.kernal.net.config.NetworkConfig;

/**
 * A class of server listener with http and nio.
 * 
 * @author vivian
 * @version 1.0
 * @since 2010/07/03
 */
public class NioHttpServer {

	private NetworkConfig config;
	private NioSocketAcceptor acceptor;
	private HttpServerHandler handler;
	
	private static NioHttpServer instance;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static NioHttpServer getInstance() {
		if(instance == null) {
			instance = new NioHttpServer();
		}
		return instance;
	}
	
	private NioHttpServer() {}

	public void setConfig(NetworkConfig config) {
		this.config = config;
	}

	public NetworkConfig getConfig() {
		return config;
	}

	public void setHandler(HttpServerHandler handler) {
		this.handler = handler;
	}

	public HttpServerHandler getHandler() {
		return handler;
	}
	
	public void createNioHttpServer() {
		if( acceptor != null ) {
			return;
		}
		try {
			// Create an acceptor
			acceptor = new NioSocketAcceptor();

			// Create a service configuration
			acceptor.getFilterChain().addLast("logger", new LoggingFilter());
			
			TextLineCodecFactory factory = new TextLineCodecFactory();
			factory.setDecoderMaxLineLength(10240);
			factory.setEncoderMaxLineLength(102400);
			acceptor.getFilterChain().addLast("protocolFilter",
					new ProtocolCodecFilter(factory));
			acceptor.setHandler( handler );
			acceptor.bind(new InetSocketAddress(config.getSourceUrl(), config
					.getSourcePort()));
			logger.info("Server now listening on " + config.getSourceUrl()
					+ ":" + config.getSourcePort());
		} catch (Exception ex) {
			logger.error( "NioHttpServer init error.", ex );
		}
	}
	
	public void shutdown() {
		acceptor.unbind();
		acceptor.dispose();
	}

}