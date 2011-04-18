package vivian.jsash.microblog.action;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.MicroblogSupport;
import vivian.jsash.microblog.message.RegisterRequest;

public class RegisterAction extends MicroblogSupport {
	
	private static final long serialVersionUID = 4390729871409851674L;
	
	private String username;
	private String password;
	private String email;
	private int question;
	private String answer;
	private String repassword;
	
	private int minLength = 4;
	private int maxLength = 20;

	public String execute() throws Exception {
		
		if( checkForm() == ERROR ) {
			return ERROR;
		}
		
		RegisterRequest req = new RegisterRequest();
		req.setUserName( getUsername() );
		req.setPassword( getUsername() );
		req.setEmailAddr( getEmail() );
		req.setQuestion( getQuestion() );
		req.setAnswer( getAnswer() );
		
		Response response = client.sendRequest(req);
		
		if( response.getErrorInfo() != null ) {
			setResultMsg(response.getErrorInfo().getErrorMsg());
			return ERROR;
		}
		
		setResultMsg("Login_Show");
		return SUCCESS;
	}
	
	public String Register() throws Exception {
		setResult(execute());
		return getResult();
	}
	
	public String Show() {
		return INPUT;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public int getQuestion() {
		return question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getRepassword() {
		return repassword;
	}

	public String checkForm() throws IOException {
		if( username==null || username.isEmpty() ) {
			setResultMsg("Username is required");
			return ERROR;
		}
		if( email==null || email.isEmpty() ) {
			setResultMsg("Email is required");
			return ERROR;
		}
		if( password==null || password.isEmpty() ) {
			setResultMsg("Password is required");
			return ERROR;
		}
		if( username.length() < minLength || username.length() > maxLength ) {
			setResultMsg("Username must in 4 ~ 20 characters!");
			return ERROR;
		}
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        if( !m.find() ) {
        	setResultMsg("Email is invalid");
			return ERROR;
        }
		if( password.length() < minLength || password.length() > maxLength ) {
			setResultMsg("Password must in 4 ~ 20 characters!");
			return ERROR;
		}
        if( repassword==null || !password.equals(repassword) ) {
        	setResultMsg("Your passwords do not match. Please try again.");
			return ERROR;
        }
		
		return SUCCESS;
	}

	public int getMinLength() {
		return minLength;
	}
	
	public int getMaxLength() {
		return maxLength;
	}

}
