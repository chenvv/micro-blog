package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseNoticeSettings;



public class NoticeSettings extends BaseNoticeSettings {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public NoticeSettings () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public NoticeSettings (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public NoticeSettings (
		java.lang.Integer id,
		boolean followedNotice,
		boolean messageNotice,
		boolean systemNotice,
		boolean repliedNotice,
		boolean followNewNotice,
		boolean followJoinNotice,
		boolean groupInviteNotice) {

		super (
			id,
			followedNotice,
			messageNotice,
			systemNotice,
			repliedNotice,
			followNewNotice,
			followJoinNotice,
			groupInviteNotice);
	}

/*[CONSTRUCTOR MARKER END]*/


}