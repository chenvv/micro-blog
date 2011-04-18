package vivian.jsash.microblog.dataitem;

import java.util.Date;

public class GroupInfoItem {
	private int groupId;
	private String groupName;
	private String suffixUrl;
	private Date createTime;
	private int createAccountId;
	private boolean isGroupPublic;
	private String description;
	private String iconUrl;

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setSuffixUrl(String suffixUrl) {
		this.suffixUrl = suffixUrl;
	}

	public String getSuffixUrl() {
		return suffixUrl;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateAccountId(int createAccountId) {
		this.createAccountId = createAccountId;
	}

	public int getCreateAccountId() {
		return createAccountId;
	}

	public void setGroupPublic(boolean isGroupPublic) {
		this.isGroupPublic = isGroupPublic;
	}

	public boolean isGroupPublic() {
		return isGroupPublic;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconUrl() {
		return iconUrl;
	}
}
