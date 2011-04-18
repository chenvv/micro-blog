package vivian.jsash.microblog.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Requests;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.kernal.common.Responses;
import vivian.jsash.microblog.MicroblogSupport;
import vivian.jsash.microblog.TextResource;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dataitem.BlogItem;
import vivian.jsash.microblog.dataitem.PageInfoItem;
import vivian.jsash.microblog.enums.BlogListTypeEnum;
import vivian.jsash.microblog.enums.GetUserTypeEnum;
import vivian.jsash.microblog.enums.UserListTypeEnum;
import vivian.jsash.microblog.message.GetBlogListRequest;
import vivian.jsash.microblog.message.GetBlogListResponse;
import vivian.jsash.microblog.message.GetUserListRequest;
import vivian.jsash.microblog.message.GetUserListResponse;
import vivian.jsash.microblog.message.GetUserRequest;
import vivian.jsash.microblog.message.GetUserResponse;
import vivian.jsash.microblog.message.PostBlogRequest;
import vivian.jsash.microblog.message.PostBlogResponse;

public class MyTopAction extends MicroblogSupport {

	private static final long serialVersionUID = 3870451812995820846L;
	
	private List<BlogItem> bloglist;
	private List<AccountItem> userlist;
	private AccountItem myaccount;
	private BlogItem addBlog;
	private int blogId;
	private String blogContent;
	private String fowardedCount;
	private String repliedCount;
	private int replyId;
	private int forwardId;
	
	public String execute() throws Exception {
		
		if( !isLogined() ) {
			return LOGIN;
		}
		
		Cookie[] cookies = httpRequest.getCookies();
		String userName = null;
		String sessionId = null;
		for( Cookie cookie : cookies ) {
			if( cookie.getName().equals(TextResource.USER_NAME)) {
				userName = cookie.getValue();
			}
			if( cookie.getName().equals(TextResource.SESSION_ID_NAME)) {
				sessionId = cookie.getValue();
			}
		}
		List<Request> reqlist = new ArrayList<Request>();
		
		GetBlogListRequest gblreq = new GetBlogListRequest();
		gblreq.setListType(BlogListTypeEnum.Mix);
		gblreq.setSession_id(sessionId);
		gblreq.setUserName(userName);
		PageInfoItem pageInfo = new PageInfoItem(0,20);
		gblreq.setPageInfo(pageInfo);
		reqlist.add(gblreq);
		
		GetUserListRequest gulreq = new GetUserListRequest();
		gulreq.setListType(UserListTypeEnum.Populer);
		gulreq.setSession_id(sessionId);
		pageInfo = new PageInfoItem(0,40);
		gulreq.setPageInfo(pageInfo);
		reqlist.add(gulreq);
		
		GetUserRequest gureq = new GetUserRequest();
		gureq.setUserType(GetUserTypeEnum.NAME);
		gureq.setAccountName(userName);
		reqlist.add(gureq);
		
		Requests requests = new Requests();
		requests.setRequests(reqlist);
		
		Responses responses = client.sendRequests(requests);
		
		if( responses.getResponses().get(0).getErrorInfo() != null ) {
			setResultMsg(responses.getResponses().get(0).getErrorInfo().getErrorMsg());
			return "get_error";
		}
		if( responses.getResponses().get(1).getErrorInfo() != null ) {
			setResultMsg(responses.getResponses().get(1).getErrorInfo().getErrorMsg());
			return "get_error";
		}
		if( responses.getResponses().get(2).getErrorInfo() != null ) {
			setResultMsg(responses.getResponses().get(2).getErrorInfo().getErrorMsg());
			return "get_error";
		}
		
		GetBlogListResponse gblresp = (GetBlogListResponse)responses.getResponses().get(0);
		setBloglist(gblresp.getBlogitems());
		
		GetUserListResponse gulresp = (GetUserListResponse)responses.getResponses().get(1);
		setUserlist(gulresp.getUsers());
		
		GetUserResponse guresp = (GetUserResponse)responses.getResponses().get(2);
		setMyaccount(guresp.getUser());
		
		return SUCCESS;
	}
	
	public String postNew() throws Exception {
		
		if( !isLogined() ) {
			setResult(LOGIN);
			return LOGIN;
		}
		
		Cookie[] cookies = httpRequest.getCookies();
		int userId = 0;
		String sessionId = null;
		for( Cookie cookie : cookies ) {
			if( cookie.getName().equals(TextResource.USER_ID)) {
				userId = Integer.parseInt(cookie.getValue());
			}
			if( cookie.getName().equals(TextResource.SESSION_ID_NAME)) {
				sessionId = cookie.getValue();
			}
		}
		
		PostBlogRequest req = new PostBlogRequest();
		req.setSession_id(sessionId);
		BlogItem bi = new BlogItem();
		bi.setContent( getBlogContent() );
		Date nowDate = new Date();
		nowDate.setTime(System.currentTimeMillis());
		bi.setCreateTime( nowDate );
		bi.setForwardedCount(0);
		bi.setRepliedCount(0);
		AccountItem account = new AccountItem();
		account.setAccountId(userId);
		bi.setAccount(account);
		
		req.setBlogitem(bi);
		
		Response response = client.sendRequest(req);
		
		if( response.getErrorInfo() != null ) {
			setResultMsg(response.getErrorInfo().getErrorMsg());
			setResult(ERROR);
			return ERROR;
		}
		
		PostBlogResponse resp = (PostBlogResponse)response;
		
		setAddBlog( resp.getAddblog() );
		setBlogId( resp.getAddblog().getBlogId() );
		setMyaccount(getAddBlog().getAccount() );
		
		setResult(SUCCESS);
		return "post_success";
	}
	
	public String postSub() throws Exception {
		
		if( !isLogined() ) {
			return LOGIN;
		}
		
		Cookie[] cookies = httpRequest.getCookies();
		int userId = 0;
		String sessionId = null;
		for( Cookie cookie : cookies ) {
			if( cookie.getName().equals(TextResource.USER_ID)) {
				userId = Integer.parseInt(cookie.getValue());
			}
			if( cookie.getName().equals(TextResource.SESSION_ID_NAME)) {
				sessionId = cookie.getValue();
			}
		}
		
		PostBlogRequest req = new PostBlogRequest();
		req.setSession_id(sessionId);
		BlogItem bi = new BlogItem();
		bi.setContent( getBlogContent() );
		Date nowDate = new Date();
		nowDate.setTime(System.currentTimeMillis());
		bi.setCreateTime( nowDate );
		bi.setForwardedCount(0);
		bi.setRepliedCount(0);
		bi.setReplyId(getReplyId());
		bi.setForwardId(getForwardId());
		AccountItem account = new AccountItem();
		account.setAccountId(userId);
		bi.setAccount(account);
		
		req.setBlogitem(bi);
		
		Response response = client.sendRequest(req);
		
		if( response.getErrorInfo() != null ) {
			setResultMsg(response.getErrorInfo().getErrorMsg());
			return ERROR;
		}
		
		PostBlogResponse resp = (PostBlogResponse)response;
		
		setAddBlog( resp.getAddblog() );
		
		setBlogId( resp.getAddblog().getBlogId() );
		
		setResult(SUCCESS);
		return "post_success";
	}
	
	public String Show() throws Exception {
		return execute();
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

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setFowardedCount(String fowardedCount) {
		this.fowardedCount = fowardedCount;
	}

	public String getFowardedCount() {
		return fowardedCount;
	}

	public void setRepliedCount(String repliedCount) {
		this.repliedCount = repliedCount;
	}

	public String getRepliedCount() {
		return repliedCount;
	}

	public void setForwardId(int forwardId) {
		this.forwardId = forwardId;
	}

	public int getForwardId() {
		return forwardId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getReplyId() {
		return replyId;
	}

	public String checkForm() throws IOException {
		return NONE;
	}

	public void setMyaccount(AccountItem myaccount) {
		this.myaccount = myaccount;
	}

	public AccountItem getMyaccount() {
		return myaccount;
	}

	public void setAddBlog(BlogItem addBlog) {
		this.addBlog = addBlog;
	}

	public BlogItem getAddBlog() {
		return addBlog;
	}
}
