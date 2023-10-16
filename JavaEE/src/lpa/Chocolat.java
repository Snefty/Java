package lpa;

public class Chocolat {
	
	public static String LAPIN = "lapin";
	public static String CLOCHE = "cloche";
	public static String OEUF = "oeuf";
	public static String POULE = "poule";
	
	private String nom;
	private float poids;
	
	public Chocolat(String nom, float poids) {
		if(nom == LAPIN) this.nom = LAPIN;
		if(nom == CLOCHE) this.nom = CLOCHE;
		if(nom == OEUF) this.nom = OEUF;
		if(nom == POULE) this.nom = POULE;
		this.poids = poids;
	}
	
	public boolean convient(Enfant e) {
		int por = 1000/e.getPoids();
		
		return this.poids == por;
	}
	
}