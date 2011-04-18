package vivian.jsash.microblog.dataitem;

public class NoticeItem {
	private int accountId;
	private boolean followedNotice;
	private boolean messageNotice;
	private boolean systemNotice;
	private boolean repliedNotice;
	private boolean followNewNotice;
	private boolean followJoinNotice;
	private boolean groupInviteNotice;

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setFollowedNotice(boolean followedNotice) {
		this.followedNotice = followedNotice;
	}

	public boolean isFollowedNotice() {
		return followedNotice;
	}

	public void setMessageNotice(boolean messageNotice) {
		this.messageNotice = messageNotice;
	}

	public boolean isMessageNotice() {
		return messageNotice;
	}

	public void setSystemNotice(boolean systemNotice) {
		this.systemNotice = systemNotice;
	}

	public boolean isSystemNotice() {
		return systemNotice;
	}

	public void setRepliedNotice(boolean repliedNotice) {
		this.repliedNotice = repliedNotice;
	}

	public boolean isRepliedNotice() {
		return repliedNotice;
	}

	public void setFollowNewNotice(boolean followNewNotice) {
		this.followNewNotice = followNewNotice;
	}

	public boolean isFollowNewNotice() {
		return followNewNotice;
	}

	public void setFollowJoinNotice(boolean followJoinNotice) {
		this.followJoinNotice = followJoinNotice;
	}

	public boolean isFollowJoinNotice() {
		return followJoinNotice;
	}

	public void setGroupInviteNotice(boolean groupInviteNotice) {
		this.groupInviteNotice = groupInviteNotice;
	}

	public boolean isGroupInviteNotice() {
		return groupInviteNotice;
	}
}
