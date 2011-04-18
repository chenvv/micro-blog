package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the account table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="account"
 */

public abstract class BaseAccount  implements Serializable {

	public static String REF = "Account";
	public static String PROP_BLOG_COUNT = "BlogCount";
	public static String PROP_FOLLOWED_COUNT = "FollowedCount";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ACCOUNT_PASSWORD = "AccountPassword";
	public static String PROP_ACCOUNT_NAME = "AccountName";
	public static String PROP_ID = "Id";
	public static String PROP_FOLLOW_COUNT = "FollowCount";
	public static String PROP_ACCOUNT_LEVEL = "AccountLevel";
	public static String PROP_ACCOUNT_ICON = "AccountIcon";


	// constructors
	public BaseAccount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccount (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccount (
		java.lang.Integer id,
		java.lang.Byte accountLevel,
		java.lang.String accountName,
		java.lang.String accountPassword,
		java.lang.Integer blogCount,
		java.util.Date createTime,
		java.lang.Integer followCount,
		java.lang.Integer followedCount) {

		this.setId(id);
		this.setAccountLevel(accountLevel);
		this.setAccountName(accountName);
		this.setAccountPassword(accountPassword);
		this.setBlogCount(blogCount);
		this.setCreateTime(createTime);
		this.setFollowCount(followCount);
		this.setFollowedCount(followedCount);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountIcon;
	private java.lang.Byte accountLevel;
	private java.lang.String accountName;
	private java.lang.String accountPassword;
	private java.lang.Integer blogCount;
	private java.util.Date createTime;
	private java.lang.Integer followCount;
	private java.lang.Integer followedCount;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
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
	 * Return the value associated with the column: ACCOUNT_ICON
	 */
	public java.lang.String getAccountIcon () {
		return accountIcon;
	}

	/**
	 * Set the value related to the column: ACCOUNT_ICON
	 * @param accountIcon the ACCOUNT_ICON value
	 */
	public void setAccountIcon (java.lang.String accountIcon) {
		this.accountIcon = accountIcon;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_LEVEL
	 */
	public java.lang.Byte getAccountLevel () {
		return accountLevel;
	}

	/**
	 * Set the value related to the column: ACCOUNT_LEVEL
	 * @param accountLevel the ACCOUNT_LEVEL value
	 */
	public void setAccountLevel (java.lang.Byte accountLevel) {
		this.accountLevel = accountLevel;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_NAME
	 */
	public java.lang.String getAccountName () {
		return accountName;
	}

	/**
	 * Set the value related to the column: ACCOUNT_NAME
	 * @param accountName the ACCOUNT_NAME value
	 */
	public void setAccountName (java.lang.String accountName) {
		this.accountName = accountName;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_PASSWORD
	 */
	public java.lang.String getAccountPassword () {
		return accountPassword;
	}

	/**
	 * Set the value related to the column: ACCOUNT_PASSWORD
	 * @param accountPassword the ACCOUNT_PASSWORD value
	 */
	public void setAccountPassword (java.lang.String accountPassword) {
		this.accountPassword = accountPassword;
	}



	/**
	 * Return the value associated with the column: BLOG_COUNT
	 */
	public java.lang.Integer getBlogCount () {
		return blogCount;
	}

	/**
	 * Set the value related to the column: BLOG_COUNT
	 * @param blogCount the BLOG_COUNT value
	 */
	public void setBlogCount (java.lang.Integer blogCount) {
		this.blogCount = blogCount;
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
	 * Return the value associated with the column: FOLLOW_COUNT
	 */
	public java.lang.Integer getFollowCount () {
		return followCount;
	}

	/**
	 * Set the value related to the column: FOLLOW_COUNT
	 * @param followCount the FOLLOW_COUNT value
	 */
	public void setFollowCount (java.lang.Integer followCount) {
		this.followCount = followCount;
	}



	/**
	 * Return the value associated with the column: FOLLOWED_COUNT
	 */
	public java.lang.Integer getFollowedCount () {
		return followedCount;
	}

	/**
	 * Set the value related to the column: FOLLOWED_COUNT
	 * @param followedCount the FOLLOWED_COUNT value
	 */
	public void setFollowedCount (java.lang.Integer followedCount) {
		this.followedCount = followedCount;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.Account)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.Account account = (vivian.jsash.microblog.dbmodel.dao.Account) obj;
			if (null == this.getId() || null == account.getId()) return false;
			else return (this.getId().equals(account.getId()));
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