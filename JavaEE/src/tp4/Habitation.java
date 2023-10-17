package tp4;

public class Habitation {
	
	private String proprietaire;
	private String adresse;
	private double surface;
	
	public Habitation(String proprietaire, String adresse, double surface) {
		this.proprietaire = proprietaire;
		this.adresse = adresse;
		this.surface = surface;
	}
	
	public double impot() {
		return 2*surface;
	}
	
	public void affiche() {
		System.out.println(proprietaire + " " + adresse + " " + surface);
	}
	
}
