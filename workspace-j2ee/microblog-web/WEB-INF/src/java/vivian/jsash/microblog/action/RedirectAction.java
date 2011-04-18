package vivian.jsash.microblog.action;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.MicroblogSupport;
import vivian.jsash.microblog.enums.GetUserTypeEnum;
import vivian.jsash.microblog.message.GetUserRequest;

public class RedirectAction extends MicroblogSupport {

	private static final long serialVersionUID = 8585038749800542926L;

	@Override
	public String execute() throws Exception {
		
		GetUserRequest req = new GetUserRequest();
		
		String[] paths = httpRequest.getServletPath().substring(1).split("/");
		req.setAccountName(paths[0]);
		req.setUserType(GetUserTypeEnum.NAME);
		
		Response response = client.sendRequest(req);
		if( response.getErrorInfo() != null ) {
			return ERROR;
		}
		
		return SUCCESS;
	}

	@Override
	public String checkForm() throws Exception {
		return null;
	}

}
