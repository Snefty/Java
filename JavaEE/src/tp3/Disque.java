package tp3;

import java.util.ArrayList;
import java.util.List;

public class Disque extends Media{
	
	private List<String> piste;
	
	public Disque(String title, String author,  int nbrExemplaire, Genre genre, List<String> piste) {
		super(title,author,nbrExemplaire,genre);
		this.piste = piste;
	}
	
	public Disque(String title, String author,int nbrExemplaire, Genre genre) {
		this(title,author,0,genre,new ArrayList<String>());
	}
	
	public Disque(String title, String author, int nbrExemplaire) {
		this(title,author,nbrExemplaire,Genre.Non_Spécifier,new ArrayList<String>());
	}
	
	public Disque(String title, String author, Genre genre) {
		this(title,author,0,genre,new ArrayList<String>());
	}
	
	public Disque(String title, String author) {
		this(title,author,0,Genre.Non_Spécifier,new ArrayList<String>());
	}
	
	public List<String> getPiste() {
		return piste;
	}
	
	public void ajouterChanson(String titreChanson) {
		piste.add(titreChanson);
	}
	
	public void ajouterChanson(List<String> titreChanson) {
		piste.addAll(titreChanson);
	}
	
	public String toString() {
		return " Disque -> " + super.getTitle() + " une chanson de " + super.getAuthor() + " du genre de " + super.getGenre() 
		+ " : nombre d'exemplaire  disponible " + super.getNbr();  
	}
}
