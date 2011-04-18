package vivian.jsash.kernal.common;

import java.io.Serializable;
import java.util.List;

public class Responses implements Serializable {

	private static final long serialVersionUID = 1063749285917594641L;
	
	private List<Response> responses;

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public List<Response> getResponses() {
		return responses;
	}

}
