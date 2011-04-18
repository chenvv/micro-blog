package vivian.jsash.kernal.common;

import java.util.HashMap;
import java.util.Map;

import vivian.jsash.kernal.exception.NoSuchHandlerException;

/**
 * A class of handler getter and register.
 * @author vivian
 * @version 1.0
 * @since 2010/07/11
 */
public class HandlerFactroy {

	private Map<String, Handler> handlerMap = new HashMap<String, Handler>();
	
	private static HandlerFactroy instance = null;
	
	private HandlerFactroy() {}
	
	public static HandlerFactroy getInstance() {
		if( instance == null ) {
			instance = new HandlerFactroy();
		}
		return instance;
	}

	public void registerHandler(String p_code, Class<? extends Handler> clazz)
			throws InstantiationException, IllegalAccessException {
		Handler handler = clazz.newInstance();
		handlerMap.put(p_code, handler);
	}

	public Handler getHandler(String p_code) throws NoSuchHandlerException {
		if (handlerMap.containsKey(p_code)) {
			return handlerMap.get(p_code);
		}
		throw new NoSuchHandlerException( p_code );
	}
}
