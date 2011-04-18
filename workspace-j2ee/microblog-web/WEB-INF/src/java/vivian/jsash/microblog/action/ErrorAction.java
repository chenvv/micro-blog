package vivian.jsash.microblog.action;

import java.io.IOException;

import vivian.jsash.microblog.MicroblogSupport;

public class ErrorAction extends MicroblogSupport {
	
	private static final long serialVersionUID = 4390729871409851674L;

	public String execute() throws Exception {
		
		if(isLogined()) {
			setResultMsg(LOGIN);
		}
		
		return SUCCESS;
	}

	public String checkForm() throws IOException {
		return SUCCESS;
	}


}
