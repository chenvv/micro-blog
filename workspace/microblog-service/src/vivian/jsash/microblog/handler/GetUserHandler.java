package vivian.jsash.microblog.handler;

import java.util.List;

import org.hibernate.Query;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.BaseHandler;
import vivian.jsash.microblog.TextResource;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.dbmodel.dao.AccountInfo;
import vivian.jsash.microblog.message.GetUserRequest;
import vivian.jsash.microblog.message.GetUserResponse;

public class GetUserHandler extends BaseHandler {

	@Override
	public Response handleRequest(Request request) {
		
		GetUserResponse response = new GetUserResponse();
		GetUserRequest req = (GetUserRequest)request;
		
		if( response.getErrorInfo() == null ) {
			Query  userQuery;
			String subHql;
			switch( req.getUserType() ) {
			case ID:
				userQuery = session.createQuery("from " + Account.REF +	" where " + Account.PROP_ID + "=?");
				userQuery.setInteger(0, req.getAccountId());
				break;
			case NAME:
				userQuery = session.createQuery("from " + Account.REF + " where " +	Account.PROP_ACCOUNT_NAME + "=?");
				userQuery.setString(0, req.getAccountName());
				break;
			default:
				subHql = "select ACCOUNT_ID from " + AccountInfo.REF + " where " + AccountInfo.PROP_EMAIL_ADDRESS + " = ?"; 
				userQuery = session.createQuery("from " + Account.REF + 
						" where " +	Account.PROP_ID + " in ( " + subHql + " ) ");
				userQuery.setString(1, req.getEmail());
				break;
			}
			List<?> users = userQuery.list();
			
			if( users==null || users.isEmpty() ) {
				return errorResponse(response, TextResource.ERR_006, TextResource.ERR_006_CODE);
			}
			Account account = (Account)users.get(0);
			AccountItem accountItem = new AccountItem();
			accountItem.setAccountId(account.getId());
			accountItem.setAccountLevel(account.getAccountLevel());
			accountItem.setAccountName(account.getAccountName());
			accountItem.setCreateTime(account.getCreateTime());
			accountItem.setFollowCount(account.getFollowCount());
			accountItem.setFollowedCount(account.getFollowedCount());
			accountItem.setBlogCount(account.getBlogCount());
			accountItem.setIconUrl(account.getAccountIcon());
			
			response.setUser(accountItem);
		}
		
		return response;
	}


}
