package tpBonus5;

public class Membre {

	private String id, nom, prenom, address;
	private int nbrEmprunt;

	public Membre(String id, String nom, String prenom, String adress) {
		this.address = adress;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nbrEmprunt = 0;
	}
	
	public Membre() {
	}
	
	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAddress() {
		return address;
	}
	
	public void augmenterNbrEmprunt() {
		nbrEmprunt++;
	}

	public int getNbrEmprunt() {
		return nbrEmprunt;
	}
	
}
