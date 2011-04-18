package vivian.jsash.microblog.dbmodel.dao;

import vivian.jsash.microblog.dbmodel.dao.base.BaseEvent;



public class Event extends BaseEvent {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Event () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Event (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Event (
		java.lang.Integer id,
		java.lang.Integer addressId,
		java.lang.Integer eventType,
		java.lang.Integer eventQuantity) {

		super (
			id,
			addressId,
			eventType,
			eventQuantity);
	}

/*[CONSTRUCTOR MARKER END]*/


}