package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseBlogs;



public class Blogs extends BaseBlogs {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Blogs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Blogs (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Blogs (
		java.lang.Integer id,
		java.lang.Integer createAccountId,
		boolean groupBlog,
		java.lang.String blogContent,
		java.lang.Integer repliedCount,
		java.lang.Integer forwardedCount,
		java.util.Date createTime) {

		super (
			id,
			createAccountId,
			groupBlog,
			blogContent,
			repliedCount,
			forwardedCount,
			createTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}