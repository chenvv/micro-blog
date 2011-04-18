package vivian.jsash.kernal.common;

public class ErrorInfo {
	private String errorMsg = null;
	private String errorCode = null;
	private Throwable cause = null;

	public ErrorInfo() {}
			
	public ErrorInfo(String errorMsg, String errorCode) {
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}
	
	public ErrorInfo(String errorMsg, String errorCode, Throwable cause) {
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.cause = cause;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public Throwable getCause() {
		return cause;
	}
}
