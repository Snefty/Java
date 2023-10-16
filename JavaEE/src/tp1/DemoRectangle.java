package tp1;

/**
 * 
 * Classe permettant de tester les classes Rectangles et Point
 * 
 * @author 59013-15-06
 * @version 1.0
 */
public class DemoRectangle {
	
	/**
	 * Fonction de principal de test
	 * @param args
	 */
	public static void main(String[] args) {
		Point unPoint = new Point(23, 94);
		Rectangle rectangle = new Rectangle(unPoint, 100, 200);
		
		
		System.out.println("Largeur : " + rectangle.getLargeur());
		System.out.println("Longueur : " + rectangle.getHauteur());
		System.out.println("L'abscysse origine : " + rectangle.abscisseOrigin());
		System.out.println("L'ordonnée origine : " + rectangle.ordonnéOrigin());
		System.out.println();
		
		System.out.println("Perimetre : " + rectangle.perimetre());
		System.out.println("Surface : " + rectangle.surface());
		
		rectangle.getOrigine().setX(12);
		rectangle.getOrigine().setY(42);
		System.out.println("L'abscysse origine : " + rectangle.abscisseOrigin());
		System.out.println("L'ordonnée origine : " + rectangle.ordonnéOrigin());
	}
	
}
