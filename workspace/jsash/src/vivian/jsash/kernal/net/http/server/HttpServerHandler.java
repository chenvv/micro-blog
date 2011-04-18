package vivian.jsash.kernal.net.http.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vivian.jsash.kernal.common.DefaultErrorResponse;
import vivian.jsash.kernal.common.ErrorInfo;
import vivian.jsash.kernal.common.Handler;
import vivian.jsash.kernal.common.HandlerFactroy;
import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Requests;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.kernal.common.Responses;
import vivian.jsash.kernal.exception.ConverterException;
import vivian.jsash.kernal.exception.NoSuchHandlerException;
import vivian.jsash.kernal.net.NetErrorCode;
import vivian.jsash.kernal.util.XmlObjConverter;

/**
 * A handler of http server.
 * 
 * @author vivian
 * @version 1.0
 * @since 2010/07/03
 */
public class HttpServerHandler implements IoHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private HandlerFactroy factory = HandlerFactroy.getInstance();
	private XmlObjConverter converter = XmlObjConverter.getInstance();

	@Override
	public void sessionOpened(IoSession session) {
		// set idle time to 60 seconds
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 60);
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		
		String responseXml;
				
		try {
			String requestXml = (String)message;
			Requests requests = (Requests) converter.xml2Object(requestXml);
			Responses responses = new Responses();
			List<Response> resps = new ArrayList<Response>();
			
			for( Request r : requests.getRequests() ) {
				Handler handler = factory.getHandler(r.getProcessCode());
				Response response = handler.processRequest(r);
				resps.add(response);
			}
			
			responses.setResponses(resps);
			responseXml = converter.object2Xml(responses);			
			
		} catch (NoSuchHandlerException e) {
			logger.error(e.getMessage(), e);
			
			String errorCode = NetErrorCode.NO_SUCH_HANDLER;
			ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), errorCode, e.getCause());
			DefaultErrorResponse response = new DefaultErrorResponse(errorInfo);
			responseXml = response.toXml();
			
		} catch (ConverterException e) {
			logger.error(e.getMessage(), e);
			
			String errorCode = NetErrorCode.MESSAGE_FORMAT_INVALID;
			ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), errorCode, e.getCause());
			DefaultErrorResponse response = new DefaultErrorResponse(errorInfo);
			responseXml = response.toXml();
			
		}

		if (responseXml != null) {
			session.write(responseXml).addListener(IoFutureListener.CLOSE);
		}
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		logger.info("Disconnecting the idle.");
		session.close(true);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		logger.error("EXCEPTION, please implement " + getClass().getName()
				+ ".exceptionCaught() for proper handling:", cause);
		session.close(true);
	}

	@Override
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}
}