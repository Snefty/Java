package tpBonus7;

public class Identite {

	private String nip;
	private String nom;
	private String prenom;
	public Identite(String nip, String nom, String prenom) {
		this.nip = nip; this.nom = nom; this.prenom = prenom; 
	}
	
	public String getNip() {
		return nip;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String toString() {
		return "["+nip+"] " + nom + " " + prenom;
	}
	
	public boolean equals(Object o) {
		if((Identite)o == null) return false;
		if(this.toString() != ((Identite)o).toString()) return false;
		return true;
	}
}
