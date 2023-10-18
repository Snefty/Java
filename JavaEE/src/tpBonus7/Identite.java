package tpBonus7;

import java.util.Objects;

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
	
	public int hashCode() {
		int hashC = 0;
		
			hashC += hashC * 12 + nip.hashCode();
			hashC += hashC * 41 + nom.hashCode();
			hashC += hashC * 24 + prenom.hashCode();
		
		return hashC;
	}

	public boolean equals(Object obj) {
		if ((Identite)obj == null)return false;
		Identite other = (Identite) obj;
		return this.nip == other.nip && this.nom == other.nom && this.prenom == other.prenom;
	}
	
	
}
