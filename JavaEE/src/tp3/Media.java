package tp3;

public class Media{

	private String title;
	private String author;
	private int nbrExemplaire;
	private String nameBus;
	private Genre genre;

	public Media(String title, String author,int nbrExemp, Genre genre) {
		this.title = title.toUpperCase();
		this.author = author.toUpperCase();
		if(nbrExemp > 0) this.nbrExemplaire = nbrExemp;
		else this.nbrExemplaire = 0;
		this.nameBus = "";
		this.genre = genre;
	}
	
	public Media() {
	}

	public void nouvelExemplaire() {
		nbrExemplaire++;
	}

	public void nouvelExemplaire(int n) {
		nbrExemplaire += n;
	}

	public void perteExemplaire() {
		nbrExemplaire--;
	}

	public boolean estPresent() {
		return nbrExemplaire > 0;
	}
	
	public int getNbr() {
		return nbrExemplaire;
	}

	public void setNbr(int nbr) {
		this.nbrExemplaire = nbr;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getNameBus() {
		return nameBus;
	}

	public void setNameBus(String nameBus) {
		this.nameBus = nameBus;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
