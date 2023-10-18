package tp5;

public class Fleur {

	private String name;
	private double prix;
	private int quantité;

	public Fleur(String name, double prix, int quantité) {
		this.name = name;
		this.prix = prix;
		this.quantité = quantité;
	}

	public String toString() {
		return name + ", coute le prix à l'unité de " + prix + ", en quantité de " + this.quantité;
	}

	public String getName() {
		return name;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantité() {
		return quantité;
	}
}
