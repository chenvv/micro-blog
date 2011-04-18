package vivian.jsash.microblog.action;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.Cookie;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.MicroblogSupport;
import vivian.jsash.microblog.TextResource;
import vivian.jsash.microblog.message.LoginRequest;
import vivian.jsash.microblog.message.LoginResponse;

public class LoginAction extends MicroblogSupport {
	
	private static final long serialVersionUID = 4390729871409851674L;
	
	private String username;
	private String password;
	private String rememberMe;

	public String execute() throws Exception {
		
		if( checkForm().equals(ERROR) ) {
			return ERROR;
		}
		
		LoginRequest req = new LoginRequest();
		req.setUserName( getUsername() );
		req.setPassword( getPassword() );

		int maxAge = -1;
		if( rememberMe!=null && rememberMe.equals("on") ) {
			Calendar calendar = Calendar.getInstance();
			long nowTime = System.currentTimeMillis();
			calendar.setTimeInMillis(nowTime);
			calendar.add(Calendar.YEAR, 10);
			maxAge = (int) ((calendar.getTimeInMillis()-nowTime)/1000);
			req.setEndDate(calendar.getTime());
		} else {
			req.setEndDate(null);
		}
		
		Response response = client.sendRequest(req);
		
		if( response.getErrorInfo() != null ) {
			setResultMsg(response.getErrorInfo().getErrorMsg());
			return ERROR;
		}
		
		LoginResponse resp = (LoginResponse)response;
		Cookie cookie = new Cookie(TextResource.LOGIN_FLAG_NAME, TextResource.TRUE_VALUE);
		cookie.setMaxAge(maxAge);
		httpResponse.addCookie(cookie);
		cookie = new Cookie(TextResource.SESSION_ID_NAME, resp.getSession_id());
		httpResponse.addCookie(cookie);
		cookie = new Cookie(TextResource.USER_NAME, resp.getAccount().getAccountName());
		httpResponse.addCookie(cookie);
		cookie = new Cookie(TextResource.USER_ID, Integer.toString(resp.getAccount().getAccountId()));
		httpResponse.addCookie(cookie);
		
		//setResultMsg( getUsername() );
		setResultMsg( "MyTop_Show" );
		return SUCCESS;
	}
	
	public String Login() throws Exception {
		setResult(execute());
		return getResult();
	}
	
	public String Logout() throws Exception {
		Cookie cookie = new Cookie(TextResource.LOGIN_FLAG_NAME, TextResource.TRUE_VALUE);
		cookie.setMaxAge(0);
		httpResponse.addCookie(cookie);
		
		return "logout";
	}
	
	public String Show() {
		return LOGIN;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public String checkForm() throws IOException {
		if( username==null || username.isEmpty() ) {
			setResultMsg("Username is required");
			return ERROR;
		}
		if( password==null || password.isEmpty() ) {
			setResultMsg("Password is required");
			return ERROR;
		}
		
		return SUCCESS;
	}


}
