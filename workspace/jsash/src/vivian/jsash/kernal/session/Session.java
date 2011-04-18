package vivian.jsash.kernal.session;

import vivian.jsash.kernal.util.MD5Encoder;

public class Session {
	
	private static String session;
	private static long liveTime;
	private static long timeOut;

	public Session(String key, long timeout) {
		liveTime = System.currentTimeMillis();
		session = MD5Encoder.encode(key + liveTime);
		timeOut = timeout;
	}
	
	public Session(String sessionStr, long livetime, long timeout) {
		liveTime = livetime;
		session = sessionStr;
		timeOut = timeout;
	}

	
	public boolean isAlive(String sessionStr) {
		if( sessionStr.equals(session) && System.currentTimeMillis()-liveTime<timeOut ) {
			return true;
		}
		return false;
	}
	
	public void refreshSession() {
		liveTime = System.currentTimeMillis();
	}
	
	public String getSession() {
		return session;
	}
}
