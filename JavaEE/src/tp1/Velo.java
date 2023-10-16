package tp1;

/**
 * Permet la creation d'un vélo
 * 
 * @author 59013-15-06
 * @version 1.0
 */
public class Velo {
	
	private int vitesse = 0;
	
	/**
	 * Permet d'accéler le vélo, en incrementant la variable vitesse
	 * @param increment
	 */
	public void accelerer(int increment) {
		vitesse += increment;
	}
	
	/**
	 * Permet de freiner le vélo, en decrementant la variable vitesse
	 * @param increment
	 */
	public void freiner(int decrement) {
		vitesse -= decrement;
	}
	
	/**
	 * Permet d'afficher l'etat du vélo, affiche la variable vitesse
	 */
	public void imprimeEtat() {
		System.out.println("vitesse: " + vitesse);
	}
	
	public int getVitesse() {
		return vitesse;
	}
	
	
}
