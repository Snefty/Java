package tp5;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe permettant de créer un bouquet via le nom et prenom d'un client donne
 * 
 * @author Alexis
 */
public class Bouquet {

	private List<Fleur> compo;
	private double prix;
	private String nomClient;
	private String prenomClient;
	
	/**
	 * Constructor de la classe bouquet
	 * 
	 * @param String nom du client
	 * @param String prenom du client
	 */
	public Bouquet(String nom, String prenom) {
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.prix = 0.0;
		this.compo = new ArrayList<Fleur>();
	}
	
	
	/**
	 * Permet D'afficher la compo du bouquet
	 */
	public void afficherCompo() {
		for(Fleur fleur : compo) {
			System.out.println("	 -> 	" + fleur);
		}
	}

	/**
	 * Permet de retourner le prix du bouquet
	 * @return int prix 
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Permet d'incrementer (augmenter) le prix du bouquet
	 * @param int prix
	 */
	public void setPrix(double prix) {
		this.prix += prix;
	}
	
	/**
	 * Permet de retourner la compo du bouquet
	 * @return
	 */
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
