package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dataitem.UserInfoItem;

public class GetUserResponse extends Response {

	private static final long serialVersionUID = -8917799676480073166L;
	
	private AccountItem user;
	private UserInfoItem userInfo;

	public void setUser(AccountItem user) {
		this.user = user;
	}

	public AccountItem getUser() {
		return user;
	}

	public void setUserInfo(UserInfoItem userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfoItem getUserInfo() {
		return userInfo;
	}

}
