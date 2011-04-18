package vivian.jsash.microblog.dataitem;

import java.util.Date;

public class BlogItem {
	private Integer blogId;
	private boolean isGroup;
	private Integer groupId;
	private String content;
	private Integer replyId;
	private Integer forwardId;
	private Integer repliedCount;
	private Integer forwardedCount;
	private Date createTime;
	private BlogItem forwardBlog;
	private AccountItem account;

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setForwardId(Integer forwardId) {
		this.forwardId = forwardId;
	}

	public Integer getForwardId() {
		return forwardId;
	}

	public void setRepliedCount(Integer repliedCount) {
		this.repliedCount = repliedCount;
	}

	public Integer getRepliedCount() {
		return repliedCount;
	}

	public void setForwardedCount(Integer forwardedCount) {
		this.forwardedCount = forwardedCount;
	}

	public Integer getForwardedCount() {
		return forwardedCount;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setForwardBlog(BlogItem forwardBlog) {
		this.forwardBlog = forwardBlog;
	}

	public BlogItem getForwardBlog() {
		return forwardBlog;
	}

	public void setAccount(AccountItem account) {
		this.account = account;
	}

	public AccountItem getAccount() {
		return account;
	}

}
