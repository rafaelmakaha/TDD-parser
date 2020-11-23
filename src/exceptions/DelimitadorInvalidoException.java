package exceptions;

public class DelimitadorInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public DelimitadorInvalidoException (String delimiter) {
		super(delimiter + " is invalid.");
	}
}
