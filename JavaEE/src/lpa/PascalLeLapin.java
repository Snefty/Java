package lpa;

import java.util.ArrayList;
import java.util.List;

public class PascalLeLapin {
	
	public static void main(String[] args) {
		
		Enfant enf1 = new Enfant("Tom", 45);
		Enfant enf2 = new Enfant("Nana", 35);
		Enfant enf3 = new Enfant("Jeremy", 42);
		Enfant enf4 = new Enfant("Jean Paul", 75);
		
		Jardin jardin1 = new Jardin("773 rue Patate");
		Jardin jardin2 = new Jardin("767 rue Jean Paul");
		
		jardin1.ajouteEnfant(enf1);
		jardin1.ajouteEnfant(enf2);
		jardin1.ajouteEnfant(enf3);
		
		jardin2.ajouteEnfant(enf4);
		
		List<Jardin> lesJardins = new ArrayList<Jardin>();
		
		lesJardins.add(jardin1);
		lesJardins.add(jardin2);
		
		Chocolat choco1 = new Chocolat("lapin", 45);
		Chocolat choco2 = new Chocolat("lapin", 85);
		Chocolat choco3 = new Chocolat("cloche", 52);
		Chocolat choco4 = new Chocolat("Poule", 35);
	
		List<Chocolat> lesChocolats = new ArrayList<>();
		
		lesChocolats.add(choco1);
		lesChocolats.add(choco2);
		lesChocolats.add(choco3);
		lesChocolats.add(choco4);
		
		LPA lpa1 = new LPA(lesChocolats, lesJardins);
	}
	
}
