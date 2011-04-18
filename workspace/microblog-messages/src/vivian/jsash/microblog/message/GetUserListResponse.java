package vivian.jsash.microblog.message;

import java.util.List;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.dataitem.AccountItem;

public class GetUserListResponse extends Response {

	private static final long serialVersionUID = -8917799676480073166L;
	
	private List<AccountItem> users;

	public void setUsers(List<AccountItem> users) {
		this.users = users;
	}

	public List<AccountItem> getUsers() {
		return users;
	}

}
