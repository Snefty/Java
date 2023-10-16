package tp3;


/**
 * @author alexi
 * @version 1.0
 */
public class Livre {

	private String title;
	private String author;
	private String editor;
	private int nbrExemplaire;
	private String genre;
	
	public Livre(String title, String author, String editor, int nbrExemplaire, String genre) {
		this.title = title.toUpperCase();
		this.author = author.toUpperCase();
		this.editor = editor;
		if(nbrExemplaire < 0) this.nbrExemplaire = 0;
		else this.nbrExemplaire = nbrExemplaire;
		this.genre = genre.toUpperCase();
	}
	
	/**
	 * Constructor Si le nombre d'exmplaire (de base mis à 0) et le genre non fournis (de base mis à "Non Spécifier" ) 
	 * @param title 
	 * @param author
	 * @param editor
	 */
	public Livre(String title, String author, String editor) {
		this(title, author, editor, 0,"Non Spécifier");
	}

	//Exercice 4
	public void nouvelExemplaire() {
		this.nbrExemplaire++;
	}

	public void nouvelExemplaire(int n) {
		this.nbrExemplaire += n;
	}

	public void perteExemplaire() {
		this.nbrExemplaire--;
	}
	
	//Exercice 5
	public String toString() {
		return "-> " + this.title + " écris par " + this.author + ", éditer par " + this.editor 
				+ " dans le genre " + this.genre + " : nombre d'exemplaire disponible " + this.nbrExemplaire;
	}
	
	//Exercice 6
	public boolean estPresent() {
		return this.nbrExemplaire > 0;
	}
	
	//Exercice 7
	public boolean equals(Livre other) {
		return this.author.equals(other.author) && this.title.equals(other.title) && this.editor.equals(other.editor);
	}
	
	//Exercice 8
	public Livre nouvelEditeur(String unEditeur) {
		return new Livre(this.title, this.author, unEditeur, this.nbrExemplaire, this.genre);
	}
	
	
	
	public int getNbrExemplaire() {
		return nbrExemplaire;
	}

	public void setNbrExemplaire(int nbrExemplaire) {
		this.nbrExemplaire = nbrExemplaire;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getEditor() {
		return editor;
	}

	public String getGenre() {
		return genre;
	}



}
