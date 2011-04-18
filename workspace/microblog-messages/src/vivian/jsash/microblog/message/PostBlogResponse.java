package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.dataitem.BlogItem;

public class PostBlogResponse extends Response {

	private static final long serialVersionUID = -1007320270639920063L;
	
	private BlogItem addblog;

	public void setAddblog(BlogItem addblog) {
		this.addblog = addblog;
	}

	public BlogItem getAddblog() {
		return addblog;
	}
	
}
