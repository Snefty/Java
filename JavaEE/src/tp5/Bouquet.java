package tp5;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {

	private List<Fleur> compo;
	private float prix;
	private String nomClient;
	private String prenomClient;

	public Bouquet(String nom, String prenom) {
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.prix = (float) 0.0;
		this.compo = new ArrayList<Fleur>();
	}

	public void afficherCompo() {
		for(Fleur fleur : compo) {
			System.out.println("	 -> 	" + fleur);
		}
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix += prix;
	}

	public List<Fleur> getCompo() {
		return compo;
	}

	public String getNomClient() {
		return nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}


}
