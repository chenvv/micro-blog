package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseBlogSettings;



public class BlogSettings extends BaseBlogSettings {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BlogSettings () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BlogSettings (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BlogSettings (
		java.lang.Integer id,
		java.lang.String language,
		java.lang.Byte timeZone,
		java.lang.String infoPublic,
		java.lang.String usedTheme) {

		super (
			id,
			language,
			timeZone,
			infoPublic,
			usedTheme);
	}

/*[CONSTRUCTOR MARKER END]*/


}