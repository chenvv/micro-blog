package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseGroup;



public class Group extends BaseGroup {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Group () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Group (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Group (
		java.lang.Integer id,
		java.lang.String groupName,
		java.lang.String suffixUrl,
		java.util.Date createTime,
		java.lang.Integer createAccountId,
		boolean groupPublic) {

		super (
			id,
			groupName,
			suffixUrl,
			createTime,
			createAccountId,
			groupPublic);
	}

/*[CONSTRUCTOR MARKER END]*/


}