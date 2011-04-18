package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blogs table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blogs"
 */

public abstract class BaseBlogs  implements Serializable {

	public static String REF = "Blogs";
	public static String PROP_FORWARDED_COUNT = "ForwardedCount";
	public static String PROP_GROUP_BLOG = "GroupBlog";
	public static String PROP_FORWARD_BLOG_ID = "ForwardBlogId";
	public static String PROP_CREATE_ACCOUNT_ID = "CreateAccountId";
	public static String PROP_REPLIED_COUNT = "RepliedCount";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_REPLY_BLOG_ID = "ReplyBlogId";
	public static String PROP_BLOG_CONTENT = "BlogContent";
	public static String PROP_GROUP_ID = "GroupId";


	// constructors
	public BaseBlogs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlogs (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlogs (
		java.lang.Integer id,
		java.lang.Integer createAccountId,
		boolean groupBlog,
		java.lang.String blogContent,
		java.lang.Integer repliedCount,
		java.lang.Integer forwardedCount,
		java.util.Date createTime) {

		this.setId(id);
		this.setCreateAccountId(createAccountId);
		this.setGroupBlog(groupBlog);
		this.setBlogContent(blogContent);
		this.setRepliedCount(repliedCount);
		this.setForwardedCount(forwardedCount);
		this.setCreateTime(createTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer createAccountId;
	private boolean groupBlog;
	private java.lang.Integer groupId;
	private java.lang.String blogContent;
	private java.lang.Integer replyBlogId;
	private java.lang.Integer forwardBlogId;
	private java.lang.Integer repliedCount;
	private java.lang.Integer forwardedCount;
	private java.util.Date createTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="BLOG_ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CREATE_ACCOUNT_ID
	 */
	public java.lang.Integer getCreateAccountId () {
		return createAccountId;
	}

	/**
	 * Set the value related to the column: CREATE_ACCOUNT_ID
	 * @param createAccountId the CREATE_ACCOUNT_ID value
	 */
	public void setCreateAccountId (java.lang.Integer createAccountId) {
		this.createAccountId = createAccountId;
	}



	/**
	 * Return the value associated with the column: GROUP_BLOG
	 */
	public boolean isGroupBlog () {
		return groupBlog;
	}

	/**
	 * Set the value related to the column: GROUP_BLOG
	 * @param groupBlog the GROUP_BLOG value
	 */
	public void setGroupBlog (boolean groupBlog) {
		this.groupBlog = groupBlog;
	}



	/**
	 * Return the value associated with the column: GROUP_ID
	 */
	public java.lang.Integer getGroupId () {
		return groupId;
	}

	/**
	 * Set the value related to the column: GROUP_ID
	 * @param groupId the GROUP_ID value
	 */
	public void setGroupId (java.lang.Integer groupId) {
		this.groupId = groupId;
	}



	/**
	 * Return the value associated with the column: BLOG_CONTENT
	 */
	public java.lang.String getBlogContent () {
		return blogContent;
	}

	/**
	 * Set the value related to the column: BLOG_CONTENT
	 * @param blogContent the BLOG_CONTENT value
	 */
	public void setBlogContent (java.lang.String blogContent) {
		this.blogContent = blogContent;
	}



	/**
	 * Return the value associated with the column: REPLY_BLOG_ID
	 */
	public java.lang.Integer getReplyBlogId () {
		return replyBlogId;
	}

	/**
	 * Set the value related to the column: REPLY_BLOG_ID
	 * @param replyBlogId the REPLY_BLOG_ID value
	 */
	public void setReplyBlogId (java.lang.Integer replyBlogId) {
		this.replyBlogId = replyBlogId;
	}



	/**
	 * Return the value associated with the column: FORWARD_BLOG_ID
	 */
	public java.lang.Integer getForwardBlogId () {
		return forwardBlogId;
	}

	/**
	 * Set the value related to the column: FORWARD_BLOG_ID
	 * @param forwardBlogId the FORWARD_BLOG_ID value
	 */
	public void setForwardBlogId (java.lang.Integer forwardBlogId) {
		this.forwardBlogId = forwardBlogId;
	}



	/**
	 * Return the value associated with the column: REPLIED_COUNT
	 */
	public java.lang.Integer getRepliedCount () {
		return repliedCount;
	}

	/**
	 * Set the value related to the column: REPLIED_COUNT
	 * @param repliedCount the REPLIED_COUNT value
	 */
	public void setRepliedCount (java.lang.Integer repliedCount) {
		this.repliedCount = repliedCount;
	}



	/**
	 * Return the value associated with the column: FORWARDED_COUNT
	 */
	public java.lang.Integer getForwardedCount () {
		return forwardedCount;
	}

	/**
	 * Set the value related to the column: FORWARDED_COUNT
	 * @param forwardedCount the FORWARDED_COUNT value
	 */
	public void setForwardedCount (java.lang.Integer forwardedCount) {
		this.forwardedCount = forwardedCount;
	}



	/**
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.Blogs)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.Blogs blogs = (vivian.jsash.microblog.dbmodel.dao.Blogs) obj;
			if (null == this.getId() || null == blogs.getId()) return false;
			else return (this.getId().equals(blogs.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}