package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe represantant un bus servant de bibliothéque, ayant un catalogue (List<Media>) regroupant Livre et Disque
 * 
 * @author alexi
 * @version 2.3
 */
public class BibliobusV2 {

	private String name;
	private List<Media> media;
	private int maxCatalogue;

	public BibliobusV2(String name, int maxCatalogue) {
		this.name = name;
		media = new ArrayList<Media>();
		this.maxCatalogue = maxCatalogue;
	}

	public BibliobusV2(String name) {
		this.name = name;
		media = new ArrayList<Media>();
		this.maxCatalogue = 200;
	}

	//Exercice 11
	public void ajoutLivre(String titre, String auteur, String editeur) {
		ajoutLivre(new LivreV2(titre, auteur, editeur));
	}

	public void ajoutLivre(LivreV2 l) {
		if(media.size() < maxCatalogue) {
			if(estConnue(l)) {

				for(Media other : media) {
					if(other instanceof LivreV2) {
						if(other.getAuthor().equals(l.getAuthor()) && other.getTitle().equals(l.getTitle())) {
							if(other.getNbr() == 0) other.nouvelExemplaire(l.getNbr()+1);
							else other.nouvelExemplaire(l.getNbr());
						}
					}
				}
			}else {
				media.add(l);
				media.get(media.size()-1).setNameBus(this.name);
			}
		}else {
			System.out.println("Plus de place !!!");
		}
	}
	
	public boolean appartient(LivreV2 livre) {
		return this.name.equals(livre.getNameBus());
	}
	
	public void ajoutDisque(String titre, String auteur) {
		ajoutDisque(new Disque(titre, auteur));
	}

	public void ajoutDisque(Disque l) {
		if(media.size() < maxCatalogue) {
			if(estConnue(l)) {

				for(Media other : media) {
					if(other instanceof Disque) {
						if(other.getAuthor().equals(l.getAuthor()) && other.getTitle().equals(l.getTitle())) {
							if(other.getNbr() == 0) other.nouvelExemplaire(l.getNbr()+1);
							else other.nouvelExemplaire(l.getNbr());
						}
					}
				}

			}else {
				media.add(l);
				media.get(media.size()-1).setNameBus(this.name);
			}
		}else {
			System.out.println("Plus de place !!!");
		}
	}

	public void supprimerLivre(int n) {

		if(n < media.size() && estConnue(media.get(n))) {
			media.remove(n);
		}else {
			System.out.println("N'existe pas dans le catalogue du bibliobus " + this.name);
		}

	}

	//Exercice 12
	public void afficherCatalogue() {
		System.out.println("Catalogue du bibliobus : " + name);
		for (Media media2 : media) {
			System.out.println(media2);
		}
	}

	public void afficherCataloguePresent() {
		System.out.println("Catalogue des livres present du bibliobus : " + name);
		for(int i=0; i<media.size() ;i++) {
			if(media.get(i).estPresent()) System.out.println("["+ (i+1) + "]"+media.get(i));

		}
	}

	public void afficherCatalogueParGenre(Genre genre) {
		System.out.println("Catalogue des livres par genre donnée du bibliobus : " + name);
		for(int i=0; i<media.size() ;i++) {
			if(media.get(i).getGenre().equals(genre)) {
				System.out.println("["+ (i+1) + "]"+media.get(i));
			}
		}
	}

	//Exercice 14
	public void afficheLivre(int n) {
		if(estConnue(media.get(n))) {
			if(media.get(n) instanceof LivreV2) {
				System.out.println(media.get(n));
			}
		}
	}

	//Verification
	public boolean estConnue(Media l) {
		for(Media other : media) {
			if(other.getAuthor().equals(l.getAuthor()) && other.getTitle().equals(l.getTitle()) ) return true;
		}
		return false;
	}

	public boolean estPresent(int n) {
		return estPresent(media.get(n));
	}

	public boolean estPresent(Media unMedia) {
		for(Media other : this.media) {
			if(other.equals(unMedia)) return other.estPresent();
		}
		return false;
	}

	//Exercice 13.1
	public int nbrExemplaireLivre(int n) {
		return nbrExemplaireLivre(media.get(n).getNbr());
	}

	public int nbrExemplaireLivre(LivreV2 l) {
		if(estPresent(l)) {
			for(int i = 0; i<media.size() ;i++) {
				if(media.get(i).equals(l)) return media.get(i).getNbr();
			}
		}
		return 0;
	}

	//Exercice 5.2
	public int nbrExemplairePourAuthor(String author) {
		int nbr = 0;
		for(Media other : media) {
			if(other.getAuthor().equals(author.toUpperCase())) {
				nbr += other.getNbr();
			}
		}
		return nbr;
	}

	public int nbrExemplairePourGenre(Genre o) {
		int nbr = 0;
		for(Media other : media) {
			if(other.getGenre().equals(o)) nbr += other.getNbr();
		}
		return nbr;
	}

	//Exercice 6.2
	public int[] tabExemplairePourAuthor(String author) {
		int[] tab = new int[media.size()];
		int tmp = 0;
		for(Media other : media) {
			if(other.getAuthor().equals(author.toUpperCase())) {
				tab[tmp] = media.indexOf(other);
				tmp++;
			}
		}
		return tab;
	}

	public int[] tabExemplairePourGenre(Genre o) {
		int[] tab = new int[media.size()];
		int tmp = 0;
		for(Media other : media) {
			if(other.getGenre().equals(o)) {
				tab[tmp] = media.indexOf(other);
				tmp++;
			}

		}
		return tab;
	}

}
