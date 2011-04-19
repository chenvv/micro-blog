package vivian.jsash.microblog.handler;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Transaction;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.kernal.util.MD5Encoder;
import vivian.jsash.microblog.BaseHandler;
import vivian.jsash.microblog.TextResource;
import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.dbmodel.dao.AccountInfo;
import vivian.jsash.microblog.message.RegisterRequest;
import vivian.jsash.microblog.message.RegisterResponse;

public class RegisterHandler extends BaseHandler {

	@Override
	public Response handleRequest(Request request) {
		
		RegisterResponse response = new RegisterResponse();
		RegisterRequest req = (RegisterRequest)request;
		
		Query query = session.createQuery("select count(*) from "+Account.REF+" where "+Account.PROP_ACCOUNT_NAME+"=?");
		query.setString(0, req.getUserName());
		int count = ((Number)query.uniqueResult()).intValue();
		if( count != 0 ) {
			return errorResponse(response, TextResource.ERR_001, TextResource.ERR_001_CODE);
		}
		
		query = session.createQuery("select count(*) from "+AccountInfo.REF+" where "+AccountInfo.PROP_EMAIL_ADDRESS+"=?");
		query.setString(0, req.getEmailAddr());
		count = ((Number)query.uniqueResult()).intValue();
		if( count != 0 ) {
			return errorResponse(response, TextResource.ERR_005, TextResource.ERR_005_CODE);
		}
		
		Account account = new Account();
		account.setAccountLevel((byte)1);
		account.setAccountName(req.getUserName());
		account.setAccountPassword( MD5Encoder.encode(req.getPassword()) );
		account.setCreateTime( new Date(System.currentTimeMillis()) );
		account.setBlogCount(0);
		account.setFollowCount(0);
		account.setFollowedCount(0);
		AccountInfo ai = new AccountInfo();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(account);
			
			ai.setId(account.getId());
			ai.setEmailAddress(req.getEmailAddr());
			session.save(ai);
			tx.commit();
			response.setResult(true);
		} catch (Exception e ) { 
			if (tx != null) {
				tx.rollback();
			}
			return errorResponse(response, TextResource.ERR_000, TextResource.ERR_000_CODE, e.getCause());
		}
		
		return response;
	}

}
