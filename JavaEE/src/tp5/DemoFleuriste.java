package tp5;

import java.util.ArrayList;
import java.util.List;

public class DemoFleuriste {

	public static void main(String[] args) {
		Fleur fleur1 = new Fleur("Rose", 6.0, 3);
		Fleur fleur2 = new Fleur("Arum", 2.1, 12);
		Fleur fleur3 = new Fleur("Hortensia",  3.5, 45);
		Fleur fleur4 = new Fleur("Jasmin", 6.2, 6);
		Fleur fleur5 = new Fleur("Anémone", 3.0, 20);
		
		List<Fleur> fleurs = new ArrayList<>();
		fleurs.add(fleur1);
		fleurs.add(fleur2);
		fleurs.add(fleur3);
		fleurs.add(fleur4);
		fleurs.add(fleur5);
		
		Fleuriste fleuriste = new Fleuriste(fleurs);
		System.out.println("il reste "+ fleuriste.quantiteEnStock("Rose") + " de rose");
		System.out.println("une rose coute " + fleuriste.prixDUneFleur("Rose"));
		fleuriste.facturation();
		
		fleuriste.creationBouquet("Thomas", "LePetitTrain");
		fleuriste.ajoutFleur("Rose",4 );
		fleuriste.ajoutFleur("Hortensia", 22);
		fleuriste.ajoutFleur("Anémone", 13);
		
		fleuriste.facturation();
		//Pas tester toutes les possibilités donc peut-etre des erreurs possibles
	}
	
}
