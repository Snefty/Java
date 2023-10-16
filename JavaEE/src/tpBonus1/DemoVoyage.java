package tpBonus1;

public class DemoVoyage {
	
	public static void main(String[] args) {
		Train t1 = new Train();
		Train t2 = new Train();
		
		Avion v1 = new Avion();
		
		Billet b1 = new Billet(t1, "Paris", "Perpignan", 850, 4, 25);
		Billet b2 = new Billet(t2, "Paris", "Lille", 750, 2, 15);
		Billet b3 = new Billet(v1, "Lille", "Berlin", 1420, 2, 0);
		
		Voyage voy1 = new Voyage("Jean-Paul", "Gauthier");
		voy1.ajouterReservation(b1);
		voy1.ajouterReservation(b2);
		voy1.ajouterReservation(b3);
		
		System.out.println(voy1);
	}
}
