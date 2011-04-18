package vivian.jsash.kernal.common;

/**
 * An abstract class of request message.
 * @author vivian
 * @version 1.0
 * @since 2010/07/11
 */
public abstract class Request implements Message {

	private static final long serialVersionUID = 6522531173391915269L;
	
	protected String PROC_CODE;
	protected String session_id;
	
	public String getProcessCode() {
		return PROC_CODE;
	}
	
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getSession_id() {
		return session_id;
	}


}
