package vivian.jsash.microblog.dataitem;

import vivian.jsash.microblog.enums.EventTypeEnum;

public class EventItem {
	private int quantity;
	private EventTypeEnum type;
	private int toId;

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setType(EventTypeEnum type) {
		this.type = type;
	}

	public EventTypeEnum getType() {
		return type;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public int getToId() {
		return toId;
	}
}
