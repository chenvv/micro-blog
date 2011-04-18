package vivian.jsash.microblog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import vivian.jsash.kernal.common.HandlerFactroy;
import vivian.jsash.kernal.net.NetworkConfigFactory;
import vivian.jsash.kernal.net.NetworkConfigFactory.ConfigurationType;
import vivian.jsash.kernal.net.config.NetworkConfig;
import vivian.jsash.kernal.net.http.server.HttpServerHandler;
import vivian.jsash.kernal.net.http.server.NioHttpServer;
import vivian.jsash.microblog.handler.GetBlogListHandler;
import vivian.jsash.microblog.handler.GetUserHandler;
import vivian.jsash.microblog.handler.GetUserListHandler;
import vivian.jsash.microblog.handler.LoginHandler;
import vivian.jsash.microblog.handler.PostBlogHandler;
import vivian.jsash.microblog.handler.RegisterHandler;

public class MicroBlogServer {

	private static NioHttpServer factory;
	private static MicroBlogServer server = new MicroBlogServer();
	
	public static void main(String[] args) {
		if (args.length > 0 && args[0].equals("stop")) {
			server.stopServer();
		} else {
			server.startServer();
		}
	}
	
	public void startServer() {
		try {
			InputStream is = MicroBlogServer.class
					.getResourceAsStream("/settings.properties");
			Properties prop = new Properties();
			prop.load(is);
			factory = NioHttpServer.getInstance();
			factory.setConfig((NetworkConfig) NetworkConfigFactory
					.getConfiguration(ConfigurationType.NetworkConfig, prop));
			factory.setHandler(new HttpServerHandler());
			factory.createNioHttpServer();
			initServiceHandler();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopServer() {
		factory.shutdown();
	}
	
	public void initServiceHandler() {
		HandlerFactroy hf = HandlerFactroy.getInstance();
		try {
			//TODO
			hf.registerHandler("register", RegisterHandler.class);
			hf.registerHandler("login", LoginHandler.class);
			hf.registerHandler("blog_list", GetBlogListHandler.class);
			hf.registerHandler("user_list", GetUserListHandler.class);
			hf.registerHandler("post_blog", PostBlogHandler.class);
			hf.registerHandler("user", GetUserHandler.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}