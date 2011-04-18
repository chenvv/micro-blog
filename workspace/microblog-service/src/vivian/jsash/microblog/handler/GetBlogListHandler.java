package vivian.jsash.microblog.handler;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.BaseHandler;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dataitem.BlogItem;
import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.dbmodel.dao.Blogs;
import vivian.jsash.microblog.dbmodel.dao.Follow;
import vivian.jsash.microblog.enums.BlogListTypeEnum;
import vivian.jsash.microblog.message.GetBlogListRequest;
import vivian.jsash.microblog.message.GetBlogListResponse;

public class GetBlogListHandler extends BaseHandler {

	@Override
	public Response handleRequest(Request request) {
		
		GetBlogListResponse response = new GetBlogListResponse();
		GetBlogListRequest req = (GetBlogListRequest)request;
		
		if( !req.getListType().equals( BlogListTypeEnum.ALL) ) { 
			checkSessionValid(req.getSession_id(),response);
		}
		if( response.getErrorInfo() == null ) {
			Query blogListQuery;
			List<?> blogs;
			String whereMainBlog = Blogs.PROP_REPLY_BLOG_ID + " is null ";
			switch( req.getListType() ) {
			case ALL:
				blogListQuery = session.createQuery("from " + Blogs.REF + 
						" where " +	whereMainBlog + "order by " + Blogs.PROP_CREATE_TIME + " desc");
				break;
			case Personal:
				blogListQuery = session.createQuery("from " + Blogs.REF + 
						" where " +	whereMainBlog + "and " + 
						Blogs.PROP_CREATE_ACCOUNT_ID + "=? order by " + Blogs.PROP_CREATE_TIME + " desc");
				blogListQuery.setInteger(0, loginSession.getAccountId());
				break;
			case Mix:
				String subHql = "select " + Follow.PROP_FOLLOWED_ID + " from " + Follow.REF + 
					" where " + Follow.PROP_ACCOUNT_ID + "=?"; 
				blogListQuery = session.createQuery("from " + Blogs.REF + 
						" where " +	whereMainBlog + "and " + Blogs.PROP_CREATE_ACCOUNT_ID + "=? or " +
						Blogs.PROP_CREATE_ACCOUNT_ID + " in ( " + subHql + " ) order by " + Blogs.PROP_CREATE_TIME + " desc");
				blogListQuery.setInteger(0, loginSession.getAccountId());
				blogListQuery.setInteger(1, loginSession.getAccountId());
				break;
			default:
				blogListQuery = session.createQuery("from " + Blogs.REF + 
						" where " +	Blogs.PROP_REPLY_BLOG_ID + "= ? or " + 
						Blogs.PROP_ID+ "=? order by " + Blogs.PROP_CREATE_TIME + " desc");
				blogListQuery.setInteger(0, loginSession.getAccountId());
				blogListQuery.setInteger(1, loginSession.getAccountId());
				break;
			}
			blogListQuery.setMaxResults( req.getPageInfo().getPageSize() );
			blogListQuery.setFirstResult( req.getPageInfo().getPageSize()*req.getPageInfo().getPageCount() );
			blogs = blogListQuery.list();
			
			List<BlogItem> blogitems = new ArrayList<BlogItem>();
			for( Object b : blogs ) {
				Blogs blog = (Blogs)b;
				BlogItem blogItem = new BlogItem();
				blogItem.setBlogId(blog.getId());
				blogItem.setContent(blog.getBlogContent());
				blogItem.setCreateTime(blog.getCreateTime());
				blogItem.setGroup(blog.isGroupBlog());
				blogItem.setGroupId(blog.getGroupId());
				blogItem.setReplyId(blog.getReplyBlogId());
				blogItem.setForwardId(blog.getForwardBlogId());
				blogItem.setRepliedCount(blog.getRepliedCount());
				blogItem.setForwardedCount(blog.getForwardedCount());
				Query accountQ = session.createQuery("from " + Account.REF + " where "+ Account.PROP_ID + "=?");
				accountQ.setInteger(0, blog.getCreateAccountId());
				List<?> alist = accountQ.list();
				Account acct = (Account)alist.get(0);
				AccountItem account = new AccountItem();
				account.setAccountId(acct.getId());
				account.setAccountName(acct.getAccountName());
				account.setCreateTime(acct.getCreateTime());
				account.setFollowCount(acct.getFollowCount());
				account.setFollowedCount(acct.getFollowedCount());
				account.setIconUrl(acct.getAccountIcon());
				blogItem.setAccount(account);
				
				if( blog.getForwardBlogId() != null ) {
					Query blogQuery = session.createQuery("from " + Blogs.REF + 
							" where " + Blogs.PROP_ID + "=?");
					blogQuery.setInteger(0, blog.getForwardBlogId());
					Blogs fwBlog = (Blogs)blogQuery.list().get(0);
					BlogItem fwBlogItem = new BlogItem();
					fwBlogItem.setBlogId(fwBlog.getId());
					fwBlogItem.setContent(fwBlog.getBlogContent());
					fwBlogItem.setCreateTime(fwBlog.getCreateTime());
					fwBlogItem.setGroup(fwBlog.isGroupBlog());
					fwBlogItem.setGroupId(fwBlog.getGroupId());
					fwBlogItem.setReplyId(fwBlog.getReplyBlogId());
					fwBlogItem.setForwardId(fwBlog.getForwardBlogId());
					fwBlogItem.setRepliedCount(fwBlog.getRepliedCount());
					fwBlogItem.setForwardedCount(fwBlog.getForwardedCount());
					accountQ = session.createQuery("from " + Account.REF + " where "+ Account.PROP_ID + "=?");
					alist = accountQ.list();
					acct = (Account)alist.get(0);
					AccountItem accountf = new AccountItem();
					accountf.setAccountId(acct.getId());
					accountf.setAccountName(acct.getAccountName());
					accountf.setCreateTime(acct.getCreateTime());
					accountf.setFollowCount(acct.getFollowCount());
					accountf.setFollowedCount(acct.getFollowedCount());
					accountf.setIconUrl(acct.getAccountIcon());
					fwBlogItem.setAccount(accountf);
					
					blogItem.setForwardBlog(fwBlogItem);
				}
				
				
				blogitems.add(blogItem);
			}
			
			response.setBlogitems(blogitems);
		}
		
		return response;
	}


}
