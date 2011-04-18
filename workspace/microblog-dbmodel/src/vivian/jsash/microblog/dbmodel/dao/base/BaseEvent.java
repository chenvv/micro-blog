package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the event table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="event"
 */

public abstract class BaseEvent  implements Serializable {

	public static String REF = "Event";
	public static String PROP_ADDRESS_ID = "AddressId";
	public static String PROP_EVENT_QUANTITY = "EventQuantity";
	public static String PROP_ID = "Id";
	public static String PROP_EVENT_TYPE = "EventType";


	// constructors
	public BaseEvent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEvent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEvent (
		java.lang.Integer id,
		java.lang.Integer addressId,
		java.lang.Integer eventType,
		java.lang.Integer eventQuantity) {

		this.setId(id);
		this.setAddressId(addressId);
		this.setEventType(eventType);
		this.setEventQuantity(eventQuantity);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer addressId;
	private java.lang.Integer eventType;
	private java.lang.Integer eventQuantity;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="EVENT_ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ADDRESS_ID
	 */
	public java.lang.Integer getAddressId () {
		return addressId;
	}

	/**
	 * Set the value related to the column: ADDRESS_ID
	 * @param addressId the ADDRESS_ID value
	 */
	public void setAddressId (java.lang.Integer addressId) {
		this.addressId = addressId;
	}



	/**
	 * Return the value associated with the column: EVENT_TYPE
	 */
	public java.lang.Integer getEventType () {
		return eventType;
	}

	/**
	 * Set the value related to the column: EVENT_TYPE
	 * @param eventType the EVENT_TYPE value
	 */
	public void setEventType (java.lang.Integer eventType) {
		this.eventType = eventType;
	}



	/**
	 * Return the value associated with the column: EVENT_QUANTITY
	 */
	public java.lang.Integer getEventQuantity () {
		return eventQuantity;
	}

	/**
	 * Set the value related to the column: EVENT_QUANTITY
	 * @param eventQuantity the EVENT_QUANTITY value
	 */
	public void setEventQuantity (java.lang.Integer eventQuantity) {
		this.eventQuantity = eventQuantity;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.Event)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.Event event = (vivian.jsash.microblog.dbmodel.dao.Event) obj;
			if (null == this.getId() || null == event.getId()) return false;
			else return (this.getId().equals(event.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}