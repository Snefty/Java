package tp3;

/**
 * 
 * Classe represantant un bus servant de bibliothéque, ayant un catalogue (tableau char[]) de livre
 * 
 * @author alexi
 * @version 1.0r
 */
public class Bibliobus {

	private String name;
	private Livre[] catalogue;
	private int indexCatalogue;

	public Bibliobus(String name, int tailleCatalogue) {
		this.name = name;
		catalogue = new Livre[tailleCatalogue];
		indexCatalogue = 0;
	}

	public Bibliobus(String name) {
		this(name, 100);
	}

	//Exercice 11
	public void ajoutLivre(String titre, String auteur, String editeur) {
		if(indexCatalogue < catalogue.length) {
			catalogue[indexCatalogue] = new Livre(titre, auteur, editeur);
			indexCatalogue++;
		}else {
			System.out.println("Plus de place !!!");
		}
	}

	public void ajoutLivre(Livre l) {
		if(indexCatalogue < catalogue.length) {
			catalogue[indexCatalogue] = l;
			indexCatalogue++;
		}else {
			System.out.println("Plus de place !!!");
		}
	}
	
	public void supprimerLivre(int n) {
		if(estConnue(catalogue[n]) ||n < indexCatalogue) {
				Livre[] newArr = null;

				for (int i = 0; i < indexCatalogue; i++) {
					if(catalogue[i] == catalogue[n]){
						newArr = new Livre[catalogue.length - 1];
						for(int index = 0; index < i; index++){
							newArr[index] = catalogue[index];
						}
						for(int j = i; j < catalogue.length - 1; j++){
							newArr[j] = catalogue[j+1];
						}
						break;
					}
				}

				catalogue = newArr;
				this.indexCatalogue--;
			}
	}
	
	//Exercice 12
	public void afficherCatalogue() {
		System.out.println("Catalogue du bibliobus : " + name);
		for(int i=0; i<indexCatalogue ;i++) {
			System.out.println("["+ (i+1) + "]"+catalogue[i]);
		}
	}

	public void afficherCataloguePresent() {
		System.out.println("Catalogue des livres present du bibliobus : " + name);
		for(int i=0; i<indexCatalogue ;i++) {
			if(catalogue[i].estPresent()) System.out.println("["+ (i+1) + "]"+catalogue[i]);

		}
	}

	public void afficherCatalogueParGenre(String genre) {
		System.out.println("Catalogue des livres par genre donnée du bibliobus : " + name);
		for(int i=0; i<indexCatalogue ;i++) {
			if(catalogue[i].getGenre().equals( genre.toUpperCase() )) {
				System.out.println("["+ (i+1) + "]"+catalogue[i]);
			}
		}
	}

	//Exercice 14
	public void afficheLivre(int n) {System.out.println(catalogue[n].toString());}

	//Verification
	public boolean estConnue(Livre l) {
		for(int i = 0; i<indexCatalogue ;i++) if(catalogue[i].equals(l)) return true;
		return false;
	}

	public boolean estPresent(int n) {
		return estPresent(catalogue[n]);
	}

	public boolean estPresent(Livre l) {
		for(int i = 0; i<indexCatalogue ;i++) if(catalogue[i].estPresent()) return true;
		return false;
	}

	//Exercice 13
	public int nbrExemplaireLivre(int n) {
		return nbrExemplaireLivre(catalogue[n]);
	}

	public int nbrExemplaireLivre(Livre l) {
		if(estPresent(l)) {
			for(int i = 0; i<indexCatalogue ;i++) {
				if(catalogue[i].equals(l)) return catalogue[i].getNbrExemplaire();
			}
		}
		return 0;
	}

	public String getTitre(int n) {
		return catalogue[n].getTitle();
	}

	public String getAuthor(int n) {
		return catalogue[n].getAuthor();
	}

	public String getEditeur(int n) {
		return catalogue[n].getEditor();
	}

	public String getGenre(int n) {
		return catalogue[n].getGenre();
	}

	public int getNbExemplaire(int n) {
		return catalogue[n].getNbrExemplaire();
	}

}
