package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blog_settings table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blog_settings"
 */

public abstract class BaseBlogSettings  implements Serializable {

	public static String REF = "BlogSettings";
	public static String PROP_BACKGROUND_IMAGE = "BackgroundImage";
	public static String PROP_USED_THEME = "UsedTheme";
	public static String PROP_ID = "Id";
	public static String PROP_LANGUAGE = "Language";
	public static String PROP_TIME_ZONE = "TimeZone";
	public static String PROP_INFO_PUBLIC = "InfoPublic";


	// constructors
	public BaseBlogSettings () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlogSettings (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlogSettings (
		java.lang.Integer id,
		java.lang.String language,
		java.lang.Byte timeZone,
		java.lang.String infoPublic,
		java.lang.String usedTheme) {

		this.setId(id);
		this.setLanguage(language);
		this.setTimeZone(timeZone);
		this.setInfoPublic(infoPublic);
		this.setUsedTheme(usedTheme);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String language;
	private java.lang.Byte timeZone;
	private java.lang.String infoPublic;
	private java.lang.String usedTheme;
	private java.lang.Integer backgroundImage;



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
	 * Return the value associated with the column: LANGUAGE
	 */
	public java.lang.String getLanguage () {
		return language;
	}

	/**
	 * Set the value related to the column: LANGUAGE
	 * @param language the LANGUAGE value
	 */
	public void setLanguage (java.lang.String language) {
		this.language = language;
	}



	/**
	 * Return the value associated with the column: TIME_ZONE
	 */
	public java.lang.Byte getTimeZone () {
		return timeZone;
	}

	/**
	 * Set the value related to the column: TIME_ZONE
	 * @param timeZone the TIME_ZONE value
	 */
	public void setTimeZone (java.lang.Byte timeZone) {
		this.timeZone = timeZone;
	}



	/**
	 * Return the value associated with the column: INFO_PUBLIC
	 */
	public java.lang.String getInfoPublic () {
		return infoPublic;
	}

	/**
	 * Set the value related to the column: INFO_PUBLIC
	 * @param infoPublic the INFO_PUBLIC value
	 */
	public void setInfoPublic (java.lang.String infoPublic) {
		this.infoPublic = infoPublic;
	}



	/**
	 * Return the value associated with the column: USED_THEME
	 */
	public java.lang.String getUsedTheme () {
		return usedTheme;
	}

	/**
	 * Set the value related to the column: USED_THEME
	 * @param usedTheme the USED_THEME value
	 */
	public void setUsedTheme (java.lang.String usedTheme) {
		this.usedTheme = usedTheme;
	}



	/**
	 * Return the value associated with the column: BACKGROUND_IMAGE
	 */
	public java.lang.Integer getBackgroundImage () {
		return backgroundImage;
	}

	/**
	 * Set the value related to the column: BACKGROUND_IMAGE
	 * @param backgroundImage the BACKGROUND_IMAGE value
	 */
	public void setBackgroundImage (java.lang.Integer backgroundImage) {
		this.backgroundImage = backgroundImage;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.BlogSettings)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.BlogSettings blogSettings = (vivian.jsash.microblog.dbmodel.dao.BlogSettings) obj;
			if (null == this.getId() || null == blogSettings.getId()) return false;
			else return (this.getId().equals(blogSettings.getId()));
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