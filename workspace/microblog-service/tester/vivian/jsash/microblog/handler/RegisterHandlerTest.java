package vivian.jsash.microblog.handler;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import junit.framework.TestCase;
import vivian.jsash.microblog.dbmodel.dao.Account;
import vivian.jsash.microblog.message.RegisterRequest;
import vivian.jsash.microblog.message.RegisterResponse;


public class RegisterHandlerTest extends TestCase {
	
	public void testHandleRequest() {
		RegisterRequest req = new RegisterRequest();
		req.setUserName("testRegister");
		req.setPassword("12345");
		req.setEmailAddr("testRegister@mmm.com");
		
		RegisterHandler handler = new RegisterHandler();
		RegisterResponse response = (RegisterResponse) handler.processRequest(req);
		
		assertEquals(true, response.isResult());
		
		req = new RegisterRequest();
		req.setUserName("testRegister");
		req.setPassword("12345");
		req.setEmailAddr("testRegister@mmm.com");
		
		response = (RegisterResponse) handler.handleRequest(req);
		
		assertEquals(1, response.getErrorInfo().getErrorCode());
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from "+Account.REF+" where "+Account.PROP_ACCOUNT_NAME+"=?");
		query.setString(0, req.getUserName());
		List<?> rs = query.list();
		if( rs != null ) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				for( Object obj : rs ) {
					session.delete(obj);
				}
				tx.commit();
			} catch (Exception e ) { 
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			} finally {
				session.close();
			}
		}
		sf.close();
		
	}
	
}
