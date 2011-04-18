package vivian.jsash.kernal.common;

public class DefaultErrorResponse extends Response {

	private static final long serialVersionUID = -7887829412340814245L;

	public DefaultErrorResponse(ErrorInfo errorInfo) {
		this.setErrorInfo(errorInfo);
	}

	public String toXml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		sb.append("<object class=\"").append(this.getClass().getName()).append("\">");
		sb.append("<object class=\"").append(errorInfo.getClass().getName()).append("\" name=\"errorInfo\">");
		sb.append("<field name=\"errorMsg\">").append(errorInfo.getErrorMsg()).append("</field>");
		sb.append("<field name=\"errorCode\">").append(errorInfo.getErrorCode()).append("</field>");
		sb.append("</object></object>");
		return sb.toString();
	}
}
