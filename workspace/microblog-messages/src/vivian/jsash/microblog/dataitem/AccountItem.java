package vivian.jsash.microblog.dataitem;

import java.util.Date;

public class AccountItem {
	private int accountId;
	private String accountName;
	private byte accountLevel;
	private String iconUrl;
	private Date createTime;
	private int followCount;
	private int followedCount;
	private int blogCount;

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountLevel(byte accountLevel) {
		this.accountLevel = accountLevel;
	}

	public byte getAccountLevel() {
		return accountLevel;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setFollowCount(int followCount) {
		this.followCount = followCount;
	}

	public int getFollowCount() {
		return followCount;
	}

	public void setFollowedCount(int followedCount) {
		this.followedCount = followedCount;
	}

	public int getFollowedCount() {
		return followedCount;
	}

	public void setBlogCount(int blogCount) {
		this.blogCount = blogCount;
	}

	public int getBlogCount() {
		return blogCount;
	}
}
