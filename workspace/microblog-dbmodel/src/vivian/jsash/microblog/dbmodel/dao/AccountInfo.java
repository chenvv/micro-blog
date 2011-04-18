package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseAccountInfo;



public class AccountInfo extends BaseAccountInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AccountInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AccountInfo (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AccountInfo (
		java.lang.Integer id,
		java.lang.String emailAddress) {

		super (
			id,
			emailAddress);
	}

/*[CONSTRUCTOR MARKER END]*/


}