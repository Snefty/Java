package tp3;

public class DemoLivre {
	
	public static void main(String[] args) {
		Livre l1 = new Livre("Toto va a l'école", "TheMotherofToto", "le petit hugo");
		Livre l2 = new Livre("Toto en retard", "TheMotherofToto", "le petit hugo", 3, "jeunesse");
		Livre l3 = new Livre("Toto va a l'école", "TheMotherofToto", "le petit hugo");
		
		
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		
		System.out.println(l1.estPresent());
		System.out.println(l2.estPresent());
		
		l1.nouvelExemplaire();
		l2.nouvelExemplaire(3);
		System.out.println();
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		System.out.println(l1.estPresent());
		System.out.println(l2.estPresent());
		
		System.out.println("egal ? " + l1.equals(l3));
		System.out.println("egal ? " + l1.equals(l2));
		
		Livre l4 = l2.nouvelEditeur("Le grand hugo");
		System.out.println(l4.toString());
	}
	
}
