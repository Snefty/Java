package tpBonus1;

public class Avion extends TypeTransport{

	private final int taxeAeroport = 20;
	
	public Avion() {
		super("Avion", 0.2);
	}

	public int getTaxeAeroport() {
		return taxeAeroport;
	}
	
	public double prix(int km, int nbrPersonne, int reduc) {
		return super.prix(km, nbrPersonne, reduc) + taxeAeroport;
	}
	
}
