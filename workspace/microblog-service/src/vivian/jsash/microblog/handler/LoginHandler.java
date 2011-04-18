package vivian.jsash.microblog.handler;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.kernal.util.MD5Encoder;
import vivian.jsash.microblog.BaseHandler;
import vivian.jsash.microblog.TextResource;
import vivian.jsash.microblog.dataitem.AccountItem;
import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.dbmodel.dao.LoginSessions;
import vivian.jsash.microblog.message.LoginRequest;
import vivian.jsash.microblog.message.LoginResponse;

public class LoginHandler extends BaseHandler {

	@Override
	public Response handleRequest(Request request) {
		
		LoginResponse response = new LoginResponse();
		LoginRequest req = (LoginRequest)request;
			
		Query query = session.createQuery("from " + Account.REF + " where " + 
				Account.PROP_ACCOUNT_NAME + "=? and " + Account.PROP_ACCOUNT_PASSWORD + "=?" );
		query.setString(0, req.getUserName());
		query.setString(1, MD5Encoder.encode( req.getPassword() ) );
		List<?> rs = query.list();
		if( rs == null || rs.size() == 0 ) {
			return errorResponse(response, TextResource.ERR_002, TextResource.ERR_002_CODE);
		} else {
			Account account = (Account)rs.get(0);
			
			LoginSessions ls;
			boolean hasSession = true;
			Query sessionQuery = session.createQuery("from "+LoginSessions.REF+" where "+LoginSessions.PROP_ACCOUNT_ID+"=?");
			sessionQuery.setInteger(0, account.getId());
			List<?> rs1 = sessionQuery.list();
			if( rs1==null || rs1.isEmpty() ) {
				ls = new LoginSessions();
				ls.setAccountId(account.getId());
				hasSession = false;
			} else {
				ls = (LoginSessions)rs1.get(0);
			}
			
			
			if( req.getEndDate() == null ) {
				ls.setNoSave(true);
				ls.setUsefullLife(new Date());
			} else {
				ls.setNoSave(false);
				ls.setUsefullLife(req.getEndDate());
			}
			vivian.jsash.kernal.session.Session loginSession = 
				new vivian.jsash.kernal.session.Session(req.getUserName(), ls.getUsefullLife().getTime());
			ls.setSessionStr( loginSession.getSession() );
			
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				if( hasSession ) {
					session.update(ls);
				} else {
					session.save(ls);
				}
				tx.commit();
				
				AccountItem ai = new AccountItem();
				ai.setAccountId(account.getId());
				ai.setAccountName(account.getAccountName());
				ai.setAccountLevel(account.getAccountLevel());
				response.setSession_id(loginSession.getSession());
				response.setAccount(ai);
				response.setEndTime(req.getEndDate());
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
