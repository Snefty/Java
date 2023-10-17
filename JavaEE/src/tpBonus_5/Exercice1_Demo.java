package tpBonus_5;

import java.util.HashSet;
import java.util.Set;

public class Exercice1_Demo {
	
	public static void main(String[] args) {
		Set<CD> cds = new HashSet<CD>();
		
		CD cd1 = new CD("E4","Il etais une fois","rap","PetitOurson");
		cds.add(cd1);
		CD cd2 = new CD("A7","Mon amour","Classique","Booba");
		cds.add(cd2);
		cds.add(new CD("I9","3 petit chat","rap","PetitOurson"));
		cds.add(new CD("O9","Mon brother","pop","EnglishHomme"));
		
		Membre m1 = new Membre("ET3", "Dupuis", "Bob", "773 rue mimosa");
		Membre m2 = new Membre("Y2U", "Durand", "Kevin", "773 rue mimosa");
		
		Mediatheque media = new Mediatheque(cds);
	
		System.out.println("Afficher disque trier par Artiste : ");
		System.out.println("============[1]============");
		for(CD cd : media.chercherParArtiste("PetitOurson")) {
			System.out.println(cd);
		}
		System.out.println("============[2]============");
		for(CD cd : media.chercherParArtiste("Booba")) {
			System.out.println(cd);
		}
		
		System.out.println("\nAfficher disque trier par Mot Clés : ");
		System.out.println("============[1]============");
		for(CD cd : media.chercherParMotCle("Mon")) {
			System.out.println(cd);
		}
		System.out.println("============[2]============");
		for(CD cd : media.chercherParMotCle("3")) {
			System.out.println(cd);
		}
		
		System.out.println();
		media.emprunter(m1, cd1);
		media.emprunter(m1, cd2);
		media.emprunter(m2, cd1);
		System.out.println(m1.getNbrEmprunt());
		System.out.println(m2.getNbrEmprunt());
		
	}
}
