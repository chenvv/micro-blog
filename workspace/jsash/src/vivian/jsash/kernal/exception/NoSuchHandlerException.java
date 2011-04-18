package vivian.jsash.kernal.exception;

public class NoSuchHandlerException extends Exception {

	private static final long serialVersionUID = -1231098868026805774L;
	
	public NoSuchHandlerException(String p_code) {
		super("The handler with process code \"" +p_code+"\" is not registered.");
	}

}
