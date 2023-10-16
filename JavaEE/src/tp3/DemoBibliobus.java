package tp3;

public class DemoBibliobus {
	
	public static void main(String[] args) {
		Livre l1 = new Livre("Toto1", "TheMotherOfToto", "le petit renard");
		Livre l2 = new Livre("Toto1", "TheMotherOfToto", "le petit renard", 5,"jeune");
		Livre l3= new Livre("Toto1", "TheMotherOfToto", "le petit renard", -1,"Vieux");
		Livre l4 = new Livre("Toto1", "TheMotherOfToto", "le petit renard", 4,"jeune");
		
		Bibliobus b1 = new Bibliobus("Tom", 5);
		
		b1.ajoutLivre(l1);
		b1.ajoutLivre(l2);
		b1.ajoutLivre(l3);
		b1.ajoutLivre(l4);
		b1.ajoutLivre("Les types de pirates", "MleMaudit", "PetitPirate");
		
		b1.afficherCatalogue();
		b1.ajoutLivre("Les types de pirates2", "MleMaudit", "PetitPirate");
		
		System.out.println();
		b1.afficheLivre(2);
		
		System.out.println();
		b1.afficherCataloguePresent();
		
		System.out.println();
		b1.afficherCatalogueParGenre("viEux");
		
		System.out.println();
		b1.supprimerLivre(2);
		b1.afficherCatalogue();
	}
	
}