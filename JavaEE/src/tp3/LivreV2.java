package tp3;


/**
 * @author alexi
 * @version 1.0
 */
public class LivreV2 extends Media{

	private String editor;
	
	public LivreV2(String title, String author, String editor, int nbrExemplaire, Genre genre) {
		super(title,author,nbrExemplaire,genre);
		this.editor = editor;
	}
	
	public LivreV2(String titre, String auteur, String editeur) {
		this(titre,auteur,editeur,0,Genre.Non_Spécifier);
	}

	//Exercice 5
	public String toString() {
		return "Livre -> " + super.getTitle() + " écris par " + super.getAuthor() + ", éditer par " + this.editor 
				+ " dans le genre " + super.getGenre() + " : nombre d'exemplaire disponible " + super.getNbr();
	}
	
	//Exercice 7
	public boolean equals(LivreV2 other) {
		return super.getAuthor().equals(other.getAuthor()) && super.getTitle().equals(other.getTitle()) && this.editor.equals(other.editor);
	}
	
	//Exercice 8
	public LivreV2 nouvelEditeur(String unEditeur) {
		return new LivreV2(super.getTitle(), super.getAuthor(), unEditeur, super.getNbr(), super.getGenre());
	}
	
	public boolean genreCorrect(Genre n) {
		for(GenreLivre other : GenreLivre.values()) {
			if(other.getGenre().equals(n.getGenre())) return true;
		}
		return false;
	}

	public String getEditor() {
		return editor;
	}
}