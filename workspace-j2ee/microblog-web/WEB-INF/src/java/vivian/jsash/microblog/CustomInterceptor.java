package vivian.jsash.microblog;

import java.util.Map;  

import vivian.jsash.microblog.dataitem.UserInfoItem;

import com.opensymphony.xwork2.Action;  
import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CustomInterceptor extends AbstractInterceptor{  

	private static final long serialVersionUID = 4971403184159861340L;

	@Override  
    public String intercept(ActionInvocation ai) throws Exception {  
        Map<String, Object> session = ai.getInvocationContext().getSession();  
        UserInfoItem user = (UserInfoItem) session.get("user");  
        if (null != user) {  
            return ai.invoke();
        } else {  
            return Action.LOGIN;  
        }  
    }  
}