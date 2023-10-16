package tp3;

public enum GenreDisque {
	
	Non_Spécifier("Non Spécifier"),
	Classique("Classique"),
	Jazz("Jazz"),
	Musique_Du_Monde("Musique_Du_Monde"),
	Rock("Rock"),
	Pop("Pop"),
	Chanson_Française("Musique_Française");
	
	String genre;
	private GenreDisque(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return this.genre;
	}
}
