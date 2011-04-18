package vivian.jsash.microblog.dataitem;

import java.util.Date;

public class MessageItem {
	private int messgaeId;
	private int addresseeId;
	private int authorId;
	private String messageContent;
	private Date createTime;
	private boolean isRreaded;
	private boolean isReplied;

	public void setMessgaeId(int messgaeId) {
		this.messgaeId = messgaeId;
	}

	public int getMessgaeId() {
		return messgaeId;
	}

	public void setAddresseeId(int addresseeId) {
		this.addresseeId = addresseeId;
	}

	public int getAddresseeId() {
		return addresseeId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setRreaded(boolean isRreaded) {
		this.isRreaded = isRreaded;
	}

	public boolean isRreaded() {
		return isRreaded;
	}

	public void setReplied(boolean isReplied) {
		this.isReplied = isReplied;
	}

	public boolean isReplied() {
		return isReplied;
	}
}
