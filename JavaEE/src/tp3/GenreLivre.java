package tp3;

public enum GenreLivre {
	
	Littérature("Littérature"),
	Littérature_Jeunesse("Littérature Jeunesse"),
	Policier("Policier"),
	Bande_Dessinée("Bande Déssinée"),
	Documentaire("Documentaire"),
	Non_Spécifier("Non Spécifier"), ;
	
	String genre;
	private GenreLivre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return this.genre;
	}
}

