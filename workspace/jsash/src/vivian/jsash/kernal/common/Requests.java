package vivian.jsash.kernal.common;

import java.io.Serializable;
import java.util.List;

public class Requests implements Serializable {

	private static final long serialVersionUID = 8607694253914199981L;
	
	private List<Request> requests;

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Request> getRequests() {
		return requests;
	}

}
