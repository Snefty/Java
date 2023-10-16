package expressionArithemitque;

public class TropDArgumentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TropDArgumentException() {
		super();
	}
	
	public TropDArgumentException(String symbole) {
		System.out.println("Trop d'argument pour l'opérateur " + symbole);
	}
	
}
