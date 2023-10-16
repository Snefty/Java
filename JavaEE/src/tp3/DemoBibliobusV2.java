package tp3;

public class DemoBibliobusV2 {
	
	public static void main(String[] args) {
		LivreV2 l1 = new LivreV2("Toto1", "TheMotherOfToto", "le petit renard");
		LivreV2 l2 = new LivreV2("Toto2", "TheMotherOfToto", "le petit renard", 5,Genre.Bande_Dessinée);
		LivreV2 l3= new LivreV2("Toto4", "TheFatherOfToto", "le petit renard", -1,Genre.Bande_Dessinée);
		LivreV2 l4 = new LivreV2("Toto1", "TheMotherOfToto", "le petit renard", 4,Genre.Littérature_Jeunesse);
		
		BibliobusV2 b1 = new BibliobusV2("Tom",10);
		
		b1.ajoutLivre(l1);
		b1.ajoutLivre(l2);
		b1.ajoutLivre(l3);
		b1.ajoutLivre(l4);
		b1.ajoutLivre("Les types de pirates", "MleMaudit", "PetitPirate");
		b1.ajoutLivre("Les types de pirates2", "MleMaudit", "PetitPirate");
		b1.afficherCatalogue();
		
		Disque d1 = new Disque("DoReMi", "Miguel");
		Disque d2 = new Disque("Xv335de", "Le grand corps malade", Genre.Rock);
		Disque d3 = new Disque("Il etait un fois", "Booba",-1,Genre.Jazz);
		Disque d4 = new Disque("Il etait un fois", "Booba",-1,Genre.Jazz);
		
		b1.ajoutDisque(d1);
		System.out.println();
		b1.ajoutDisque(d2);
		b1.ajoutDisque(d3);
		b1.ajoutDisque(d4);
		b1.afficherCatalogue();
		
		System.out.println();
		System.out.println(b1.nbrExemplairePourAuthor("TheMotherOfToto"));
		System.out.println(b1.nbrExemplairePourGenre(Genre.Bande_Dessinée));
		
		System.out.println("\n1-------------------------------------------------");
		b1.supprimerLivre(1);
		b1.afficherCatalogue();
		b1.supprimerLivre(7);
		
		System.out.println();
		for(int i : b1.tabExemplairePourAuthor("TheMotherOfToto")) {System.out.print("["+i+"]"); }
		System.out.println();
		for(int i : b1.tabExemplairePourAuthor("MleMaudit")) {System.out.print("["+i+"]"); }
		
		
		System.out.println("\n\n2-------------------------------------------------");
		b1.afficheLivre(1);
		
		
		System.out.println("\n3-------------------------------------------------");
		b1.afficherCataloguePresent();
		
		System.out.println("4-------------------------------------------------");
		b1.afficherCatalogueParGenre(Genre.Non_Spécifier);
		
	}
	
}