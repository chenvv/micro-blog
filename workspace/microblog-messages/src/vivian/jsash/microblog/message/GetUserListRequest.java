package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.microblog.dataitem.PageInfoItem;
import vivian.jsash.microblog.enums.UserListTypeEnum;

public class GetUserListRequest extends Request {

	private static final long serialVersionUID = -2579086429725090168L;
	
	private UserListTypeEnum listType;
	private String keyword;
	private String groupName;
	private Integer accountId;
	private PageInfoItem pageInfo;
	
	public GetUserListRequest() {
		PROC_CODE = "user_list";
	}

	public void setListType(UserListTypeEnum listType) {
		this.listType = listType;
	}

	public UserListTypeEnum getListType() {
		return listType;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
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
