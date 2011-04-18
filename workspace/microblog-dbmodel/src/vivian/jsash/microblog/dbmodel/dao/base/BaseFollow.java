package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the follow table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="follow"
 */

public abstract class BaseFollow  implements Serializable {

	public static String REF = "Follow";
	public static String PROP_ACCOUNT_ID = "AccountId";
	public static String PROP_ID = "Id";
	public static String PROP_FOLLOWED_ID = "FollowedId";


	// constructors
	public BaseFollow () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFollow (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFollow (
		java.lang.Integer id,
		java.lang.Integer accountId,
		java.lang.Integer followedId) {

		this.setId(id);
		this.setAccountId(accountId);
		this.setFollowedId(followedId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer accountId;
	private java.lang.Integer followedId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="INDEX_ID"
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
	 * Return the value associated with the column: ACCOUNT_ID
	 */
	public java.lang.Integer getAccountId () {
		return accountId;
	}

	/**
	 * Set the value related to the column: ACCOUNT_ID
	 * @param accountId the ACCOUNT_ID value
	 */
	public void setAccountId (java.lang.Integer accountId) {
		this.accountId = accountId;
	}



	/**
	 * Return the value associated with the column: FOLLOWED_ID
	 */
	public java.lang.Integer getFollowedId () {
		return followedId;
	}

	/**
	 * Set the value related to the column: FOLLOWED_ID
	 * @param followedId the FOLLOWED_ID value
	 */
	public void setFollowedId (java.lang.Integer followedId) {
		this.followedId = followedId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.Follow)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.Follow follow = (vivian.jsash.microblog.dbmodel.dao.Follow) obj;
			if (null == this.getId() || null == follow.getId()) return false;
			else return (this.getId().equals(follow.getId()));
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