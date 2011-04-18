package vivian.jsash.microblog.message;

import java.util.List;

import vivian.jsash.kernal.common.Response;
import vivian.jsash.microblog.dataitem.BlogItem;

public class GetBlogListResponse extends Response {

	private static final long serialVersionUID = -1157667098205342104L;
	
	private List<BlogItem> blogitems;

	public void setBlogitems(List<BlogItem> blogitems) {
		this.blogitems = blogitems;
	}

	public List<BlogItem> getBlogitems() {
		return blogitems;
	}


}
