package vivian.jsash.microblog.message;

import vivian.jsash.kernal.common.Request;
import vivian.jsash.microblog.dataitem.BlogItem;

public class PostBlogRequest extends Request {

	private static final long serialVersionUID = -343038954097967341L;
	
	private BlogItem blogitem;

	public PostBlogRequest() {
		PROC_CODE = "post_blog";
	}
	
	public void setBlogitem(BlogItem blogitem) {
		this.blogitem = blogitem;
	}

	public BlogItem getBlogitem() {
		return blogitem;
	}	


}
