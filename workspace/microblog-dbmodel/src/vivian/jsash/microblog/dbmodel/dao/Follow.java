package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseFollow;



public class Follow extends BaseFollow {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Follow () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Follow (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Follow (
		java.lang.Integer id,
		java.lang.Integer accountId,
		java.lang.Integer followedId) {

		super (
			id,
			accountId,
			followedId);
	}

/*[CONSTRUCTOR MARKER END]*/


}