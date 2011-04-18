package vivian.jsash.microblog;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import vivian.jsash.kernal.net.config.NetworkConfig;
import vivian.jsash.kernal.net.http.client.HttpClientHandler;
import vivian.jsash.kernal.net.http.client.NioHttpClient;

import com.opensymphony.xwork2.ActionSupport;

public abstract class MicroblogSupport extends ActionSupport {
	
	private static final long serialVersionUID = -9103117661156379665L;
	
	public static NioHttpClient client = new NioHttpClient();
	public static NetworkConfig config = new NetworkConfig();
	public static HttpClientHandler handler = new HttpClientHandler();
	static {
		config.setDestUrl(ServletActionContext.getServletContext().getInitParameter("server_ip"));
		config.setDestPort(Integer.parseInt(ServletActionContext.getServletContext().getInitParameter("port")));
		config.setTimeout(Integer.parseInt(ServletActionContext.getServletContext().getInitParameter("timeout")));
		client.setConfig(config);
		client.setHandler(handler);
		client.createNioHttpClient();
	}
	
	protected HttpServletRequest httpRequest = ServletActionContext.getRequest();
	protected HttpServletResponse httpResponse = ServletActionContext.getResponse();
	protected Cookie[] cookies = httpRequest.getCookies();
	
	protected boolean isLogined() {
		for( Cookie cookie : cookies ) {
			if( cookie.getName().equals(TextResource.LOGIN_FLAG_NAME) && 
					cookie.getValue().equals(TextResource.TRUE_VALUE) ) {
				return true;
			}
		}
		return false;
	}
	
	public abstract String execute() throws Exception;
	public abstract String checkForm() throws Exception;
	
	private String result;
	private String resultMsg;
	
	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getResultMsg() {
		return resultMsg;
	}

}
