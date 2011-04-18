package vivian.jsash.kernal.common;

/**
 * An abstract class of message handler.
 * 
 * @author vivian
 * @version 1.0
 * @since 2010/07/11
 */
public abstract class Handler {

	public abstract Response processRequest(Request request);

	public abstract Response errorResponse(Response response, ErrorInfo errorInfo);

}
