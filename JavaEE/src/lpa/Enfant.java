package lpa;

public class Enfant {
	
	private String name;
	private float poids;
	
	public Enfant(String name, float poids) {
		this.name = name;
		this.poids = poids;
	}
	
	public int getPoids() {
		return (int) this.poids;
	}
	
	public void mangeChocolat(Chocolat c) {
		System.out.println("Miam!");
	}
	
}