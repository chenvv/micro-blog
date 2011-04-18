package vivian.jsash.microblog.handler;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.BaseHandler;
import vivian.jsash.microblog.EventProsessor;
import vivian.jsash.microblog.TextResource;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dataitem.BlogItem;
import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.dbmodel.dao.Blogs;
import vivian.jsash.microblog.message.PostBlogRequest;
import vivian.jsash.microblog.message.PostBlogResponse;

public class PostBlogHandler extends BaseHandler {

	@Override
	public Response handleRequest(Request request) {
		
		PostBlogResponse response = new PostBlogResponse();
		PostBlogRequest req = (PostBlogRequest)request;
		
		checkSessionValid(req.getSession_id(),response);
		if( response.getErrorInfo() == null ) {
			Blogs blog = new Blogs();
			blog.setBlogContent( req.getBlogitem().getContent() );
			blog.setCreateAccountId( req.getBlogitem().getAccount().getAccountId() );
			blog.setCreateTime( req.getBlogitem().getCreateTime() );
			blog.setForwardBlogId( req.getBlogitem().getForwardId() );
			blog.setForwardedCount(0);
			blog.setGroupId(req.getBlogitem().getGroupId());
			blog.setGroupBlog(req.getBlogitem().isGroup());
			blog.setRepliedCount(0);
			blog.setReplyBlogId(req.getBlogitem().getReplyId());
			
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(blog);
				
				Query q = session.createQuery("from "+Account.REF+" where "+Account.PROP_ID+"=?");
				q.setInteger(0, req.getBlogitem().getAccount().getAccountId());
				List<?> list = q.list();
				Account account = (Account)list.get(0);
				account.setBlogCount(account.getBlogCount()+1);
				session.update(account);
				
				tx.commit();
				
				EventProsessor.processPostedEvent(sf, blog.getCreateAccountId() );
				if( blog.getForwardBlogId()!=null && blog.getForwardBlogId() != 0 ) {
					EventProsessor.processFowardedEvent(sf, blog.getForwardBlogId() );
				} 
				if( blog.getReplyBlogId()!=null && blog.getReplyBlogId() != 0 ) {
					EventProsessor.processRepliedEvent(sf, blog.getReplyBlogId() );
				}
				if( blog.getBlogContent().indexOf("@") != -1 ) {
					String[] atSubStrs = blog.getBlogContent().split("@");
					for( String atSub : atSubStrs ) {
						String[] names = atSub.split("[ ,.;':]");
						if( !names[0].isEmpty() ) {
							EventProsessor.processAtedEvent(sf, names[0] );
						}
					}
				}
				
				BlogItem addblog = new BlogItem();
				addblog.setBlogId(blog.getId());
				addblog.setContent(blog.getBlogContent());
				addblog.setCreateTime(blog.getCreateTime());
				addblog.setForwardId(blog.getForwardBlogId());
				addblog.setForwardedCount(blog.getForwardedCount());
				addblog.setGroup(blog.isGroupBlog());
				addblog.setGroupId(blog.getGroupId());
				addblog.setRepliedCount(blog.getRepliedCount());
				addblog.setReplyId(blog.getReplyBlogId());

				AccountItem acct = new AccountItem();
				acct.setAccountId(account.getId());
				acct.setAccountName(account.getAccountName());
				acct.setCreateTime(account.getCreateTime());
				acct.setFollowCount(account.getFollowCount());
				acct.setFollowedCount(account.getFollowedCount());
				acct.setIconUrl(account.getAccountIcon());
				addblog.setAccount(acct);
				
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
					Query accountQ = session.createQuery("from " + Account.REF + " where "+ Account.PROP_ID + "=?");
					List<?> alist = accountQ.list();
					account = (Account)alist.get(0);
					AccountItem accountf = new AccountItem();
					accountf.setAccountId(account.getId());
					accountf.setAccountName(account.getAccountName());
					accountf.setCreateTime(account.getCreateTime());
					accountf.setFollowCount(account.getFollowCount());
					accountf.setFollowedCount(account.getFollowedCount());
					accountf.setIconUrl(account.getAccountIcon());
					fwBlogItem.setAccount(accountf);
					
					addblog.setForwardBlog(fwBlogItem);
				}
				
				response.setAddblog(addblog);
			} catch (Exception e ) { 
				if (tx != null) {
					tx.rollback();
				}
				return errorResponse(response, TextResource.ERR_000, TextResource.ERR_000_CODE, e.getCause());
			}
		}
		
		return response;
	}

}
