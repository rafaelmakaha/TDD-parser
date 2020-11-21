package exceptions;

public class ArquivoNaoEncontradoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArquivoNaoEncontradoException(String fileName) {
		super(fileName + " not found.");
	}
}
