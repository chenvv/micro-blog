package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Request;

public class RegisterRequest extends Request {

	private static final long serialVersionUID = -343038954097967341L;
	
	private String userName;
	private String password;
	private String emailAddr;
	private int question;
	private String answer;
	
	public RegisterRequest() {
		PROC_CODE = "register";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getEmailAddr() {
		return emailAddr;
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

}
