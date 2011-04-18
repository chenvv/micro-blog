package vivian.jsash.kernal.exception;

public class ConverterException extends Exception {

	private static final long serialVersionUID = -4464057484069459239L;

	public ConverterException(Class<?> clazz, Throwable throwable) {
		super("The Object and XML converter can not convert Object to XML.("
				+ clazz.getName() + ")", throwable);
	}

	public ConverterException(String xml, Throwable throwable) {
		super("The Object and XML converter can not convert XML to Object.("
				+ xml + ")", throwable);
	}
}
