package vivian.jsash.kernal.net.http.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vivian.jsash.kernal.common.DefaultErrorResponse;
import vivian.jsash.kernal.common.ErrorInfo;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.kernal.common.Responses;
import vivian.jsash.kernal.exception.ConverterException;
import vivian.jsash.kernal.net.http.HttpResponseMessage;
import vivian.jsash.kernal.util.XmlObjConverter;

/**
 * A handler of http server.
 * 
 * @author vivian
 * @version 1.0
 * @since 2010/07/03
 */
public class HttpClientHandler implements IoHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private XmlObjConverter converter = XmlObjConverter.getInstance();
	private Responses responses = null;
	private int responseCode = 0;

	@Override
	public void sessionOpened(IoSession session) {
		// set idle time to 60 seconds
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 60);
	}

	@Override
	public void messageReceived(IoSession session, Object message) {

		try {
			responses = (Responses) converter.xml2Object((String)message);
		} catch (ConverterException e) {
			responseCode = HttpResponseMessage.HTTP_STATUS_INTERNAL_ERROR;
			ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), "HTTP" + Integer.toString(responseCode), e.getCause());
			responses = new Responses();
			List<Response> responseList = new ArrayList<Response>();
			responseList.add(new DefaultErrorResponse(errorInfo));
			responses.setResponses(responseList);
		}
//		HttpResponseMessage responseMessage = (HttpResponseMessage) message;
//		responseCode = responseMessage.getResponseCode();
//		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
//		
//		try {
//			responses = (Responses) converter.xml2Object(responseMessage
//					.getBody().getString(decoder));
//		} catch (Exception e) {
//			responseCode = HttpResponseMessage.HTTP_STATUS_INTERNAL_ERROR;
//			ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), "HTTP" + Integer.toString(responseCode), e.getCause());
//			responses = new Responses();
//			List<Response> responseList = new ArrayList<Response>();
//			responseList.add(new DefaultErrorResponse(errorInfo));
//			responses.setResponses(responseList);
//				
//		}

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

	public Responses getResponses() {
		return responses;
	}
	
	public int getResponseCode() {
		return responseCode;
	}
}