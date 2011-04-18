package vivian.jsash.microblog.handler;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.BaseHandler;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.dbmodel.dao.Follow;
import vivian.jsash.microblog.dbmodel.dao.Group;
import vivian.jsash.microblog.dbmodel.dao.GroupUsers;
import vivian.jsash.microblog.dbmodel.dao.LoginSessions;
import vivian.jsash.microblog.enums.UserListTypeEnum;
import vivian.jsash.microblog.message.GetUserListRequest;
import vivian.jsash.microblog.message.GetUserListResponse;

public class GetUserListHandler extends BaseHandler {

	@Override
	public Response handleRequest(Request request) {
		
		GetUserListResponse response = new GetUserListResponse();
		GetUserListRequest req = (GetUserListRequest)request;
		
		if( req.getListType().equals(  UserListTypeEnum.Follow) ||
				req.getListType().equals(  UserListTypeEnum.Followed) ) { 
			checkSessionValid(req.getSession_id(),response);
		}
		if( response.getErrorInfo() == null ) {
			Query userListQuery;
			List<?> users;
			String subHql;
			switch( req.getListType() ) {
			case New:
				userListQuery = session.createQuery("from " + Account.REF + 
						"order by " + Account.PROP_CREATE_TIME);
				break;
			case Online:
				subHql = "select " + LoginSessions.PROP_ACCOUNT_ID + " from " + 
						LoginSessions.REF + " where " +LoginSessions.PROP_ONLINE_FLAG + "=1"; 
				userListQuery = session.createQuery("from " + Account.REF + 
						" where " +	Account.PROP_ID + " in ( " + subHql + " ) order by " + Account.PROP_ACCOUNT_NAME);
				break;
			case Populer:
				userListQuery = session.createQuery("from " + Account.REF + " order by " + Account.PROP_FOLLOWED_COUNT);
				break;
			case Group:
				subHql = "select " + GroupUsers.PROP_ACCOUNT_ID + " from " + 
						GroupUsers.REF + " where " +GroupUsers.PROP_ID + " in (" +
						"select " + Group.PROP_ID + " from " + Group.REF+ " where name = ?)"; 
				userListQuery = session.createQuery("from " + Account.REF + 
						" where " +	Account.PROP_ID + " in ( " + subHql + " ) order by " + Account.PROP_ACCOUNT_NAME);
				userListQuery.setString(0, req.getGroupName());
				break;
			case Follow:
				subHql = "select FOLLOWED_ID from " + Follow.REF + " where ACCOUNT_ID = ?"; 
				userListQuery = session.createQuery("from " + Account.REF + 
						" where " +	Account.PROP_ID + " in ( " + subHql + " ) order by " + Account.PROP_ACCOUNT_NAME);
				userListQuery.setInteger(0, req.getAccountId());
				break;
			default:
				subHql = "select ACCOUNT_ID from " + Follow.REF + " where FOLLOWED_ID = ?"; 
				userListQuery = session.createQuery("from " + Account.REF + 
						" where " +	Account.PROP_ID + " in ( " + subHql + " ) order by " + Account.PROP_ACCOUNT_NAME);
				userListQuery.setInteger(0, req.getAccountId());
				break;
			}
			userListQuery.setMaxResults( req.getPageInfo().getPageSize() );
			userListQuery.setFirstResult( req.getPageInfo().getPageSize()*req.getPageInfo().getPageCount() );
			users = userListQuery.list();
			
			List<AccountItem> accountItems = new ArrayList<AccountItem>();
			for( Object user : users ) {
				Account account = (Account)user;
				AccountItem accountItem = new AccountItem();
				accountItem.setAccountId(account.getId());
				accountItem.setAccountLevel(account.getAccountLevel());
				accountItem.setAccountName(account.getAccountName());
				accountItem.setCreateTime(account.getCreateTime());
				accountItem.setFollowCount(account.getFollowCount());
				accountItem.setFollowedCount(account.getFollowedCount());
				accountItem.setBlogCount(account.getBlogCount());
				accountItem.setIconUrl(account.getAccountIcon());
				
				accountItems.add(accountItem);
			}
			
			response.setUsers(accountItems);
		}
		
		return response;
	}


}
