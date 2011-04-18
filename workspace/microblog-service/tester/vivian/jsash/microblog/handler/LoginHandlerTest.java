package vivian.jsash.microblog.handler;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import junit.framework.TestCase;
import vivian.jsash.microblog.dbmodel.dao.LoginSessions;
import vivian.jsash.microblog.message.LoginRequest;
import vivian.jsash.microblog.message.LoginResponse;


public class LoginHandlerTest extends TestCase {
	
	public void testHandleRequest() {	
		LoginRequest req = new LoginRequest();
		req.setUserName("testRegister");
		req.setPassword("12345");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.YEAR, 1);
		req.setEndDate( c.getTime() );

		LoginHandler handler = new LoginHandler();
		LoginResponse response = (LoginResponse) handler.handleRequest(req);
		
		assertEquals(2, response.getErrorInfo().getErrorCode());
		
		req = new LoginRequest();
		req.setUserName("test1111");
		req.setPassword("12345");
		req.setEndDate( c.getTime() );
		
		response = (LoginResponse) handler.handleRequest(req);
		
		assertEquals("test1111", response.getAccount().getAccountName());
		assertNull(response.getErrorInfo());
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from "+LoginSessions.REF+" where "+LoginSessions.PROP_SESSION_STR+"=?");
		query.setString(0, response.getSession_id());
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
