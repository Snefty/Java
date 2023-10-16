package tpBonus1;

public class TypeTransport {
	
	private String type;
	private double prixKm;
	
	public TypeTransport(String type, double prixKm) {
		this.type = type;
		this.prixKm = prixKm;
	}
	
	public String getType() {
		return type;
	}

	public double prix(int km, int nbrPersonne, int reduc) {
		double prix = (this.prixKm*km);
		
		prix = prix * nbrPersonne;
		
		if(reduc == 0.0) {
			return prix;
		}
		
		int d = (int) (prix * reduc/100);
		System.out.println(d);
		prix = prix - d;
		
		return prix;
		
	}
	
}
