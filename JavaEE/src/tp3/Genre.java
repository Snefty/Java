package tp3;

public enum Genre {

	Littérature("Littérature"),
	Littérature_Jeunesse("Littérature Jeunesse"),
	Policier("Policier"),
	Bande_Dessinée("Bande Déssinée"),
	Documentaire("Documentaire"),
	Non_Spécifier("Non Spécifier"),
	Classique("Classique"),
	Jazz("Jazz"),
	Musique_Du_Monde("Musique_Du_Monde"),
	Rock("Rock"),
	Pop("Pop"),
	Chanson_Française("Musique_Française");
	
	String genre;
	private Genre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return this.genre;
	}
}
