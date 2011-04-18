package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseGroupUsers;



public class GroupUsers extends BaseGroupUsers {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public GroupUsers () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public GroupUsers (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public GroupUsers (
		java.lang.Integer id,
		java.lang.Integer accountId) {

		super (
			id,
			accountId);
	}

/*[CONSTRUCTOR MARKER END]*/


}