package vivian.jsash.microblog.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Requests;
import vivian.jsash.kernal.common.Responses;
import vivian.jsash.microblog.MicroblogSupport;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dataitem.BlogItem;
import vivian.jsash.microblog.dataitem.PageInfoItem;
import vivian.jsash.microblog.enums.BlogListTypeEnum;
import vivian.jsash.microblog.enums.UserListTypeEnum;
import vivian.jsash.microblog.message.GetBlogListRequest;
import vivian.jsash.microblog.message.GetBlogListResponse;
import vivian.jsash.microblog.message.GetUserListRequest;
import vivian.jsash.microblog.message.GetUserListResponse;

public class MainAction extends MicroblogSupport {

	private static final long serialVersionUID = 3870451812995820846L;
	
	private List<BlogItem> bloglist;
	private List<AccountItem> userlist;
	
	public String execute() throws Exception {
		
		if( isLogined() ) {
			return LOGIN;
		}
		
		List<Request> reqlist = new ArrayList<Request>();
		
		GetBlogListRequest gblreq = new GetBlogListRequest();
		gblreq.setListType(BlogListTypeEnum.ALL);
		PageInfoItem pageInfo = new PageInfoItem(0,20);
		gblreq.setPageInfo(pageInfo);
		reqlist.add(gblreq);
		
		GetUserListRequest gulreq = new GetUserListRequest();
		gulreq.setListType(UserListTypeEnum.Populer);
		pageInfo = new PageInfoItem(0,40);
		gulreq.setPageInfo(pageInfo);
		reqlist.add(gulreq);
		
		Requests requests = new Requests();
		requests.setRequests(reqlist);
		
		Responses responses = client.sendRequests(requests);
		
		if( responses.getResponses().get(0).getErrorInfo() != null ) {
			setResultMsg(responses.getResponses().get(0).getErrorInfo().getErrorMsg());
			return ERROR;
		}
		if( responses.getResponses().get(1).getErrorInfo() != null ) {
			setResultMsg(responses.getResponses().get(1).getErrorInfo().getErrorMsg());
			return ERROR;
		}
		
		GetBlogListResponse gblresp = (GetBlogListResponse)responses.getResponses().get(0);
		setBloglist(gblresp.getBlogitems());
		
		GetUserListResponse gulresp = (GetUserListResponse)responses.getResponses().get(1);
		setUserlist(gulresp.getUsers());
		
		return SUCCESS;
	}

	public void setBloglist(List<BlogItem> bloglist) {
		this.bloglist = bloglist;
	}

	public List<BlogItem> getBloglist() {
		return bloglist;
	}

	public void setUserlist(List<AccountItem> userlist) {
		this.userlist = userlist;
	}

	public List<AccountItem> getUserlist() {
		return userlist;
	}
	
	public String checkForm() throws IOException {
		return NONE;
	}

}
