package tpBonus1;

public class Billet {

	private TypeTransport type;
	private String villeDepart;
	private String VilleArrivé;
	private int nbrKm;
	private int nbrPersonne;
	private int reduc;
	private double prixBillet;
	
	public Billet(TypeTransport type,String villeDepart, String villeArrivé, int nbrKm, int nbrPersonne, int reduc) {
		this.villeDepart = villeDepart;
		this.VilleArrivé = villeArrivé;
		this.nbrKm = nbrKm;
		this.nbrPersonne = nbrPersonne;
		this.reduc = reduc;
		this.type = type;
		prixBillet = this.type.prix(this.nbrKm, this.nbrPersonne, this.reduc);
	}
	
	public double getPrixBillet() {
		return prixBillet;
	}

	public String toString() {
	String a = "Reservation de " + this.type.getType() + "\n\n";
	
	a += "Depart : " + this.villeDepart + " - Arrivee : " + this.VilleArrivé + " - Distance : " + this.nbrKm + " km\n";
	a += "Nombre de places : " + this.nbrPersonne + " - Reduction : " + this.reduc + "\n";
	a += "			Prix : " + this.prixBillet + "$\n";
	
	return a;
	}
}
