package vivian.jsash.microblog.message;

import java.util.Date;

import vivian.jsash.kernal.common.Request;

public class LoginRequest extends Request {

	private static final long serialVersionUID = -6909147220416331168L;
	
	private String userName;
	private String password;
	private int question;
	private String answer;
	private Date endDate;
	
	public LoginRequest() {
		PROC_CODE = "login";
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

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}


}
