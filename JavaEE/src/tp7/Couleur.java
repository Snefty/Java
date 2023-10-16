package tp7;

public enum Couleur {
	
	CARREAU('♦'),
	PIQUE('♠'),
	COEUR('❤'),
	TREFLE('♣');
	
	private char couleur;
	private Couleur(char couleur) {
		this.couleur = couleur;
	}
	
	public char getCouleur() {
		return couleur;
	}
	
}
