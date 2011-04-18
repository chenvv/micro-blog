package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseLoginSessions;



public class LoginSessions extends BaseLoginSessions {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LoginSessions () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LoginSessions (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LoginSessions (
		java.lang.Integer id,
		java.lang.Integer accountId,
		java.lang.String sessionStr,
		boolean onlineFlag,
		boolean noSave) {

		super (
			id,
			accountId,
			sessionStr,
			onlineFlag,
			noSave);
	}

/*[CONSTRUCTOR MARKER END]*/


}