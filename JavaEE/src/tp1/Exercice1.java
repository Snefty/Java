package tp1;

/**
 * Ma premiere class en Java
 * 
 * @author Donnez Alexis
 * @version 1.0
 */
public class Exercice1 {

	private String message = "";

	/**
	 * Constructor de la classe
	 * @param message
	 */
	public Exercice1(String message) {
		this.message = message;
	}

	/**
	 * Permet de retourner le message de la variable message
	 * @return chaine de charatere
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Permet de modifier la variable grace à un argument donné
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Permet d'afficher le message ecris dans la variable message
	 */
	public void affiche() {
		System.out.println(getMessage());
	}

}
