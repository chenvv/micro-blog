package vivian.jsash.microblog;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import vivian.jsash.kernal.common.ErrorInfo;
import vivian.jsash.kernal.common.Handler;
import vivian.jsash.kernal.common.Request;
import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.dbmodel.dao.LoginSessions;

public abstract class BaseHandler extends Handler {
	
	protected static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	protected Session session;
	protected LoginSessions loginSession;
	
	protected void openSession() {
		session = sf.openSession();
	}
	
	protected void closeSession() {
		session.close();
	}

	protected Response checkSessionValid( String session_id, Response response ) {
		Query sessionQuery = session.createQuery("from " + LoginSessions.REF + " where " + 
				LoginSessions.PROP_SESSION_STR + "=?");
		sessionQuery.setString(0, session_id);
		List<?> rs = sessionQuery.list();
		if( rs == null || rs.size() == 0 ) {
			return errorResponse(response, TextResource.ERR_003, TextResource.ERR_003_CODE);
		} else {
			loginSession = (LoginSessions)rs.get(0);
			if( !loginSession.isNoSave() ) {
				if( System.currentTimeMillis() > loginSession.getUsefullLife().getTime() ) {
					return errorResponse(response, TextResource.ERR_004, TextResource.ERR_004_CODE);
				}
			}
		}
		
		return response;
	}
	
	protected Response errorResponse(Response response, String errMsg, String errCode) {
		ErrorInfo ei = new ErrorInfo(errMsg, errCode);
		response.setErrorInfo(ei);
		return response;
	}

	protected Response errorResponse(Response response, String errMsg, String errCode, Throwable cause) {
		ErrorInfo ei = new ErrorInfo(errMsg, errCode, cause);
		response.setErrorInfo(ei);
		return response;
	}
	
	protected abstract Response handleRequest(Request request);
	
	@Override
	public Response errorResponse(Response response, ErrorInfo ei) {
		response.setErrorInfo(ei);
		return null;
	}
	
	@Override
	public Response processRequest(Request request) {
		openSession();
		Response response = handleRequest(request);
		closeSession();
		
		return response;
	}

}
