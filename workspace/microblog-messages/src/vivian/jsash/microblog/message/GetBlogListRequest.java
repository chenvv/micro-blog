package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.microblog.dataitem.PageInfoItem;
import vivian.jsash.microblog.enums.BlogListTypeEnum;

public class GetBlogListRequest extends Request {

	private static final long serialVersionUID = -7332935503405963937L;

	private BlogListTypeEnum listType;
	private String userName;
	private PageInfoItem pageInfo;
	
	public GetBlogListRequest() {
		PROC_CODE = "blog_list";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setListType(BlogListTypeEnum listType) {
		this.listType = listType;
	}

	public BlogListTypeEnum getListType() {
		return listType;
	}

	public void setPageInfo(PageInfoItem pageInfo) {
		this.pageInfo = pageInfo;
	}

	public PageInfoItem getPageInfo() {
		return pageInfo;
	}


}
