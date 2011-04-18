package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the account_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="account_info"
 */

public abstract class BaseAccountInfo  implements Serializable {

	public static String REF = "AccountInfo";
	public static String PROP_HOMEPAGE = "Homepage";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_BIRTHDAY = "Birthday";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_MOBILE = "Mobile";
	public static String PROP_EMAIL_ADDRESS = "EmailAddress";
	public static String PROP_ID = "Id";
	public static String PROP_REAL_NAME = "RealName";
	public static String PROP_SEX = "Sex";


	// constructors
	public BaseAccountInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccountInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccountInfo (
		java.lang.Integer id,
		java.lang.String emailAddress) {

		this.setId(id);
		this.setEmailAddress(emailAddress);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String address;
	private java.util.Date birthday;
	private java.lang.String description;
	private java.lang.String emailAddress;
	private java.lang.String homepage;
	private java.lang.String mobile;
	private java.lang.String realName;
	private java.lang.String sex;



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
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: BIRTHDAY
	 */
	public java.util.Date getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: BIRTHDAY
	 * @param birthday the BIRTHDAY value
	 */
	public void setBirthday (java.util.Date birthday) {
		this.birthday = birthday;
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
	 * Return the value associated with the column: EMAIL_ADDRESS
	 */
	public java.lang.String getEmailAddress () {
		return emailAddress;
	}

	/**
	 * Set the value related to the column: EMAIL_ADDRESS
	 * @param emailAddress the EMAIL_ADDRESS value
	 */
	public void setEmailAddress (java.lang.String emailAddress) {
		this.emailAddress = emailAddress;
	}



	/**
	 * Return the value associated with the column: HOMEPAGE
	 */
	public java.lang.String getHomepage () {
		return homepage;
	}

	/**
	 * Set the value related to the column: HOMEPAGE
	 * @param homepage the HOMEPAGE value
	 */
	public void setHomepage (java.lang.String homepage) {
		this.homepage = homepage;
	}



	/**
	 * Return the value associated with the column: MOBILE
	 */
	public java.lang.String getMobile () {
		return mobile;
	}

	/**
	 * Set the value related to the column: MOBILE
	 * @param mobile the MOBILE value
	 */
	public void setMobile (java.lang.String mobile) {
		this.mobile = mobile;
	}



	/**
	 * Return the value associated with the column: REAL_NAME
	 */
	public java.lang.String getRealName () {
		return realName;
	}

	/**
	 * Set the value related to the column: REAL_NAME
	 * @param realName the REAL_NAME value
	 */
	public void setRealName (java.lang.String realName) {
		this.realName = realName;
	}



	/**
	 * Return the value associated with the column: SEX
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: SEX
	 * @param sex the SEX value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.AccountInfo)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.AccountInfo accountInfo = (vivian.jsash.microblog.dbmodel.dao.AccountInfo) obj;
			if (null == this.getId() || null == accountInfo.getId()) return false;
			else return (this.getId().equals(accountInfo.getId()));
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