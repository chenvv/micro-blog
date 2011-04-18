package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the group_users table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="group_users"
 */

public abstract class BaseGroupUsers  implements Serializable {

	public static String REF = "GroupUsers";
	public static String PROP_ACCOUNT_ID = "AccountId";
	public static String PROP_ID = "Id";
	public static String PROP_ADMIN = "Admin";


	// constructors
	public BaseGroupUsers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGroupUsers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGroupUsers (
		java.lang.Integer id,
		java.lang.Integer accountId) {

		this.setId(id);
		this.setAccountId(accountId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer accountId;
	private boolean admin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.Assigned"
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
	 * Return the value associated with the column: ADMIN
	 */
	public boolean isAdmin () {
		return admin;
	}

	/**
	 * Set the value related to the column: ADMIN
	 * @param admin the ADMIN value
	 */
	public void setAdmin (boolean admin) {
		this.admin = admin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.GroupUsers)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.GroupUsers groupUsers = (vivian.jsash.microblog.dbmodel.dao.GroupUsers) obj;
			if (null == this.getId() || null == groupUsers.getId()) return false;
			else return (this.getId().equals(groupUsers.getId()));
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