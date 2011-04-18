package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseAccount;



public class Account extends BaseAccount {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Account () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Account (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Account (
		java.lang.Integer id,
		java.lang.Byte accountLevel,
		java.lang.String accountName,
		java.lang.String accountPassword,
		java.lang.Integer blogCount,
		java.util.Date createTime,
		java.lang.Integer followCount,
		java.lang.Integer followedCount) {

		super (
			id,
			accountLevel,
			accountName,
			accountPassword,
			blogCount,
			createTime,
			followCount,
			followedCount);
	}

/*[CONSTRUCTOR MARKER END]*/


}