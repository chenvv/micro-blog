package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the login_sessions table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="login_sessions"
 */

public abstract class BaseLoginSessions  implements Serializable {

	public static String REF = "LoginSessions";
	public static String PROP_NO_SAVE = "NoSave";
	public static String PROP_ACCOUNT_ID = "AccountId";
	public static String PROP_USEFULL_LIFE = "UsefullLife";
	public static String PROP_ONLINE_FLAG = "OnlineFlag";
	public static String PROP_ID = "Id";
	public static String PROP_SESSION_STR = "SessionStr";


	// constructors
	public BaseLoginSessions () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLoginSessions (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLoginSessions (
		java.lang.Integer id,
		java.lang.Integer accountId,
		java.lang.String sessionStr,
		boolean onlineFlag,
		boolean noSave) {

		this.setId(id);
		this.setAccountId(accountId);
		this.setSessionStr(sessionStr);
		this.setOnlineFlag(onlineFlag);
		this.setNoSave(noSave);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer accountId;
	private java.util.Date usefullLife;
	private java.lang.String sessionStr;
	private boolean onlineFlag;
	private boolean noSave;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="SESSION_ID"
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
	 * Return the value associated with the column: USEFULL_LIFE
	 */
	public java.util.Date getUsefullLife () {
		return usefullLife;
	}

	/**
	 * Set the value related to the column: USEFULL_LIFE
	 * @param usefullLife the USEFULL_LIFE value
	 */
	public void setUsefullLife (java.util.Date usefullLife) {
		this.usefullLife = usefullLife;
	}



	/**
	 * Return the value associated with the column: SESSION_STR
	 */
	public java.lang.String getSessionStr () {
		return sessionStr;
	}

	/**
	 * Set the value related to the column: SESSION_STR
	 * @param sessionStr the SESSION_STR value
	 */
	public void setSessionStr (java.lang.String sessionStr) {
		this.sessionStr = sessionStr;
	}



	/**
	 * Return the value associated with the column: ONLINE_FLAG
	 */
	public boolean isOnlineFlag () {
		return onlineFlag;
	}

	/**
	 * Set the value related to the column: ONLINE_FLAG
	 * @param onlineFlag the ONLINE_FLAG value
	 */
	public void setOnlineFlag (boolean onlineFlag) {
		this.onlineFlag = onlineFlag;
	}



	/**
	 * Return the value associated with the column: NO_SAVE
	 */
	public boolean isNoSave () {
		return noSave;
	}

	/**
	 * Set the value related to the column: NO_SAVE
	 * @param noSave the NO_SAVE value
	 */
	public void setNoSave (boolean noSave) {
		this.noSave = noSave;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.LoginSessions)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.LoginSessions loginSessions = (vivian.jsash.microblog.dbmodel.dao.LoginSessions) obj;
			if (null == this.getId() || null == loginSessions.getId()) return false;
			else return (this.getId().equals(loginSessions.getId()));
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