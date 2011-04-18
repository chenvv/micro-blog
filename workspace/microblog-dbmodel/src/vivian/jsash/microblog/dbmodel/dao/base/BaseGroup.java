package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the group table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="group"
 */

public abstract class BaseGroup  implements Serializable {

	public static String REF = "Group";
	public static String PROP_GROUP_ICON = "GroupIcon";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CREATE_ACCOUNT_ID = "CreateAccountId";
	public static String PROP_GROUP_NAME = "GroupName";
	public static String PROP_GROUP_PUBLIC = "GroupPublic";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ID = "Id";
	public static String PROP_SUFFIX_URL = "SuffixUrl";


	// constructors
	public BaseGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGroup (
		java.lang.Integer id,
		java.lang.String groupName,
		java.lang.String suffixUrl,
		java.util.Date createTime,
		java.lang.Integer createAccountId,
		boolean groupPublic) {

		this.setId(id);
		this.setGroupName(groupName);
		this.setSuffixUrl(suffixUrl);
		this.setCreateTime(createTime);
		this.setCreateAccountId(createAccountId);
		this.setGroupPublic(groupPublic);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupName;
	private java.lang.String suffixUrl;
	private java.lang.String description;
	private java.lang.Integer groupIcon;
	private java.util.Date createTime;
	private java.lang.Integer createAccountId;
	private boolean groupPublic;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="GROUP_ID"
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
	 * Return the value associated with the column: GROUP_NAME
	 */
	public java.lang.String getGroupName () {
		return groupName;
	}

	/**
	 * Set the value related to the column: GROUP_NAME
	 * @param groupName the GROUP_NAME value
	 */
	public void setGroupName (java.lang.String groupName) {
		this.groupName = groupName;
	}



	/**
	 * Return the value associated with the column: SUFFIX_URL
	 */
	public java.lang.String getSuffixUrl () {
		return suffixUrl;
	}

	/**
	 * Set the value related to the column: SUFFIX_URL
	 * @param suffixUrl the SUFFIX_URL value
	 */
	public void setSuffixUrl (java.lang.String suffixUrl) {
		this.suffixUrl = suffixUrl;
	}



	/**
	 * Return the value associated with the column: DESCRIPTION
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: DESCRIPTION
	 * @param description the DESCRIPTION value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: GROUP_ICON
	 */
	public java.lang.Integer getGroupIcon () {
		return groupIcon;
	}

	/**
	 * Set the value related to the column: GROUP_ICON
	 * @param groupIcon the GROUP_ICON value
	 */
	public void setGroupIcon (java.lang.Integer groupIcon) {
		this.groupIcon = groupIcon;
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
	 * Return the value associated with the column: GROUP_PUBLIC
	 */
	public boolean isGroupPublic () {
		return groupPublic;
	}

	/**
	 * Set the value related to the column: GROUP_PUBLIC
	 * @param groupPublic the GROUP_PUBLIC value
	 */
	public void setGroupPublic (boolean groupPublic) {
		this.groupPublic = groupPublic;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.Group)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.Group group = (vivian.jsash.microblog.dbmodel.dao.Group) obj;
			if (null == this.getId() || null == group.getId()) return false;
			else return (this.getId().equals(group.getId()));
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