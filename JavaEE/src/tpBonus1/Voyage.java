package tpBonus1;

import java.util.ArrayList;
import java.util.List;

public class Voyage {
	
	private String nom;
	private String prenom;
	private List<Billet> transports;
	
	public Voyage(String name, String prenom) {
		this.nom = name;
		this.prenom = prenom;
		this.transports = new ArrayList<Billet>();
	}
	
	public void ajouterReservation(Billet billet) {
		this.transports.add(billet);
	}
	
	public String toString() {
		System.out.println("Voyage de " + this.nom + " " + this.prenom);
		double prixMax = 0.0;
		
			for(Billet billet : transports) {
				System.out.println(billet);
				prixMax += billet.getPrixBillet();
			}
			
			System.out.println("Total : " + prixMax + "$");
			
		return "";
	}
	
}
