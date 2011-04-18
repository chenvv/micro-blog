package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the notice_settings table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="notice_settings"
 */

public abstract class BaseNoticeSettings  implements Serializable {

	public static String REF = "NoticeSettings";
	public static String PROP_MESSAGE_NOTICE = "MessageNotice";
	public static String PROP_GROUP_INVITE_NOTICE = "GroupInviteNotice";
	public static String PROP_FOLLOWED_NOTICE = "FollowedNotice";
	public static String PROP_FOLLOW_NEW_NOTICE = "FollowNewNotice";
	public static String PROP_ID = "Id";
	public static String PROP_REPLIED_NOTICE = "RepliedNotice";
	public static String PROP_FOLLOW_JOIN_NOTICE = "FollowJoinNotice";
	public static String PROP_SYSTEM_NOTICE = "SystemNotice";


	// constructors
	public BaseNoticeSettings () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNoticeSettings (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseNoticeSettings (
		java.lang.Integer id,
		boolean followedNotice,
		boolean messageNotice,
		boolean systemNotice,
		boolean repliedNotice,
		boolean followNewNotice,
		boolean followJoinNotice,
		boolean groupInviteNotice) {

		this.setId(id);
		this.setFollowedNotice(followedNotice);
		this.setMessageNotice(messageNotice);
		this.setSystemNotice(systemNotice);
		this.setRepliedNotice(repliedNotice);
		this.setFollowNewNotice(followNewNotice);
		this.setFollowJoinNotice(followJoinNotice);
		this.setGroupInviteNotice(groupInviteNotice);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private boolean followedNotice;
	private boolean messageNotice;
	private boolean systemNotice;
	private boolean repliedNotice;
	private boolean followNewNotice;
	private boolean followJoinNotice;
	private boolean groupInviteNotice;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.Assigned"
     *  column="ACCOUNT_ID"
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
	 * Return the value associated with the column: FOLLOWED_NOTICE
	 */
	public boolean isFollowedNotice () {
		return followedNotice;
	}

	/**
	 * Set the value related to the column: FOLLOWED_NOTICE
	 * @param followedNotice the FOLLOWED_NOTICE value
	 */
	public void setFollowedNotice (boolean followedNotice) {
		this.followedNotice = followedNotice;
	}



	/**
	 * Return the value associated with the column: MESSAGE_NOTICE
	 */
	public boolean isMessageNotice () {
		return messageNotice;
	}

	/**
	 * Set the value related to the column: MESSAGE_NOTICE
	 * @param messageNotice the MESSAGE_NOTICE value
	 */
	public void setMessageNotice (boolean messageNotice) {
		this.messageNotice = messageNotice;
	}



	/**
	 * Return the value associated with the column: SYSTEM_NOTICE
	 */
	public boolean isSystemNotice () {
		return systemNotice;
	}

	/**
	 * Set the value related to the column: SYSTEM_NOTICE
	 * @param systemNotice the SYSTEM_NOTICE value
	 */
	public void setSystemNotice (boolean systemNotice) {
		this.systemNotice = systemNotice;
	}



	/**
	 * Return the value associated with the column: REPLIED_NOTICE
	 */
	public boolean isRepliedNotice () {
		return repliedNotice;
	}

	/**
	 * Set the value related to the column: REPLIED_NOTICE
	 * @param repliedNotice the REPLIED_NOTICE value
	 */
	public void setRepliedNotice (boolean repliedNotice) {
		this.repliedNotice = repliedNotice;
	}



	/**
	 * Return the value associated with the column: FOLLOW_NEW_NOTICE
	 */
	public boolean isFollowNewNotice () {
		return followNewNotice;
	}

	/**
	 * Set the value related to the column: FOLLOW_NEW_NOTICE
	 * @param followNewNotice the FOLLOW_NEW_NOTICE value
	 */
	public void setFollowNewNotice (boolean followNewNotice) {
		this.followNewNotice = followNewNotice;
	}



	/**
	 * Return the value associated with the column: FOLLOW_JOIN_NOTICE
	 */
	public boolean isFollowJoinNotice () {
		return followJoinNotice;
	}

	/**
	 * Set the value related to the column: FOLLOW_JOIN_NOTICE
	 * @param followJoinNotice the FOLLOW_JOIN_NOTICE value
	 */
	public void setFollowJoinNotice (boolean followJoinNotice) {
		this.followJoinNotice = followJoinNotice;
	}



	/**
	 * Return the value associated with the column: GROUP_INVITE_NOTICE
	 */
	public boolean isGroupInviteNotice () {
		return groupInviteNotice;
	}

	/**
	 * Set the value related to the column: GROUP_INVITE_NOTICE
	 * @param groupInviteNotice the GROUP_INVITE_NOTICE value
	 */
	public void setGroupInviteNotice (boolean groupInviteNotice) {
		this.groupInviteNotice = groupInviteNotice;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.NoticeSettings)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.NoticeSettings noticeSettings = (vivian.jsash.microblog.dbmodel.dao.NoticeSettings) obj;
			if (null == this.getId() || null == noticeSettings.getId()) return false;
			else return (this.getId().equals(noticeSettings.getId()));
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