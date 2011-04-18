package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.microblog.dataitem.PageInfoItem;
import vivian.jsash.microblog.enums.GetUserTypeEnum;

public class GetUserRequest extends Request {

	private static final long serialVersionUID = -2579086429725090168L;
	
	private GetUserTypeEnum userType;
	private String accountName;
	private String email;
	private Integer accountId;
	private PageInfoItem pageInfo;
	
	public GetUserRequest() {
		PROC_CODE = "user";
	}

	public void setUserType(GetUserTypeEnum userType) {
		this.userType = userType;
	}

	public GetUserTypeEnum getUserType() {
		return userType;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setPageInfo(PageInfoItem pageInfo) {
		this.pageInfo = pageInfo;
	}

	public PageInfoItem getPageInfo() {
		return pageInfo;
	}

	
}
