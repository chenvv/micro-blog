package vivian.jsash.microblog.message;

import java.util.Date;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.dataitem.AccountItem;

public class LoginResponse extends Response {

	private static final long serialVersionUID = 7416610128129000742L;
	
	private String session_id;
	private Date endTime;
	private AccountItem account;

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setAccount(AccountItem account) {
		this.account = account;
	}

	public AccountItem getAccount() {
		return account;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return endTime;
	}

}
