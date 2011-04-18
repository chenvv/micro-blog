package vivian.jsash.microblog.dbmodel.dao.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the messgaes table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="messgaes"
 */

public abstract class BaseMessgaes  implements Serializable {

	public static String REF = "Messgaes";
	public static String PROP_REPLIED_FLAG = "RepliedFlag";
	public static String PROP_MESSAGE_CONTENT = "MessageContent";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_ADDRESSEE_ID = "AddresseeId";
	public static String PROP_ID = "Id";
	public static String PROP_AUTHOR_ID = "AuthorId";
	public static String PROP_READED_FLAG = "ReadedFlag";


	// constructors
	public BaseMessgaes () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMessgaes (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMessgaes (
		java.lang.Integer id,
		java.lang.Integer addresseeId,
		java.lang.Integer authorId,
		java.lang.String messageContent,
		java.util.Date createTime,
		boolean readedFlag,
		boolean repliedFlag) {

		this.setId(id);
		this.setAddresseeId(addresseeId);
		this.setAuthorId(authorId);
		this.setMessageContent(messageContent);
		this.setCreateTime(createTime);
		this.setReadedFlag(readedFlag);
		this.setRepliedFlag(repliedFlag);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer addresseeId;
	private java.lang.Integer authorId;
	private java.lang.String messageContent;
	private java.util.Date createTime;
	private boolean readedFlag;
	private boolean repliedFlag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="MESSAGE_ID"
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
	 * Return the value associated with the column: ADDRESSEE_ID
	 */
	public java.lang.Integer getAddresseeId () {
		return addresseeId;
	}

	/**
	 * Set the value related to the column: ADDRESSEE_ID
	 * @param addresseeId the ADDRESSEE_ID value
	 */
	public void setAddresseeId (java.lang.Integer addresseeId) {
		this.addresseeId = addresseeId;
	}



	/**
	 * Return the value associated with the column: AUTHOR_ID
	 */
	public java.lang.Integer getAuthorId () {
		return authorId;
	}

	/**
	 * Set the value related to the column: AUTHOR_ID
	 * @param authorId the AUTHOR_ID value
	 */
	public void setAuthorId (java.lang.Integer authorId) {
		this.authorId = authorId;
	}



	/**
	 * Return the value associated with the column: MESSAGE_CONTENT
	 */
	public java.lang.String getMessageContent () {
		return messageContent;
	}

	/**
	 * Set the value related to the column: MESSAGE_CONTENT
	 * @param messageContent the MESSAGE_CONTENT value
	 */
	public void setMessageContent (java.lang.String messageContent) {
		this.messageContent = messageContent;
	}



	/**
	 * Return the value associated with the column: CREATE_TIME
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: CREATE_TIME
	 * @param createTime the CREATE_TIME value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: READED_FLAG
	 */
	public boolean isReadedFlag () {
		return readedFlag;
	}

	/**
	 * Set the value related to the column: READED_FLAG
	 * @param readedFlag the READED_FLAG value
	 */
	public void setReadedFlag (boolean readedFlag) {
		this.readedFlag = readedFlag;
	}



	/**
	 * Return the value associated with the column: REPLIED_FLAG
	 */
	public boolean isRepliedFlag () {
		return repliedFlag;
	}

	/**
	 * Set the value related to the column: REPLIED_FLAG
	 * @param repliedFlag the REPLIED_FLAG value
	 */
	public void setRepliedFlag (boolean repliedFlag) {
		this.repliedFlag = repliedFlag;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof vivian.jsash.microblog.dbmodel.dao.Messgaes)) return false;
		else {
			vivian.jsash.microblog.dbmodel.dao.Messgaes messgaes = (vivian.jsash.microblog.dbmodel.dao.Messgaes) obj;
			if (null == this.getId() || null == messgaes.getId()) return false;
			else return (this.getId().equals(messgaes.getId()));
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