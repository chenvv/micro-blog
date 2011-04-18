package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseMessgaes;



public class Messgaes extends BaseMessgaes {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Messgaes () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Messgaes (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Messgaes (
		java.lang.Integer id,
		java.lang.Integer addresseeId,
		java.lang.Integer authorId,
		java.lang.String messageContent,
		java.util.Date createTime,
		boolean readedFlag,
		boolean repliedFlag) {

		super (
			id,
			addresseeId,
			authorId,
			messageContent,
			createTime,
			readedFlag,
			repliedFlag);
	}

/*[CONSTRUCTOR MARKER END]*/


}