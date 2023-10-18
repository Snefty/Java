package tpBonus5;

public class Personne {

	private String nom, prenom;
	private Genre genre;
	
	public Personne(String nom, String prenom, Genre genre) {
		this.genre = genre;
		this.nom = nom;
		this.prenom= prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Genre getGenre() {
		return genre;
	}
	
	public String toString() {
		return this.nom + " " + this.prenom + " " + this.genre;
	}
	
}
