package tp7;

public class Carte {
	
	private Couleur couleur;
	private Rang rang;
	
	public Carte(Couleur couleur, Rang rang) {
		this.couleur = couleur;
		this.rang = rang;
	}
	
	public Carte() {
		this.couleur = Couleur.CARREAU;
		this.rang = Rang.DEUX;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Rang getRang() {
		return rang;
	}
	
	public void setRang(Rang rang) {
		this.rang = rang;
	}

	public String toString() {
		return rang + "" + couleur.getCouleur();
	}
}
