package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Response;

public class RegisterResponse extends Response {

	private static final long serialVersionUID = -1007320270639920063L;
	
	private boolean result;

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean isResult() {
		return result;
	}
	
}
