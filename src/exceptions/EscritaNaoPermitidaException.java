package exceptions;

public class EscritaNaoPermitidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public EscritaNaoPermitidaException(){
		super("The output file path is not valid.");
	}
}