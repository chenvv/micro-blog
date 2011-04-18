package vivian.jsash.kernal.common;

/**
 * An abstract class of response message.
 * @author vivian
 * @version 1.0
 * @since 2010/07/11
 */
public abstract class Response implements Message {

	private static final long serialVersionUID = -3046404058820049072L;

	protected ErrorInfo errorInfo = null;

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

}
