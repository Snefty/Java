package tpBonus5;

import java.util.HashSet;
import java.util.Set;

public class Mediatheque {
	
	private Set<CD> cds;
	private Set<Membre> membres;
	
	public Mediatheque(Set<CD> cds) {
		this.cds = cds;
		this.membres = new HashSet<Membre>();
	}
	
	public boolean peutEmprunter(Membre m) {
		
		if(m.getNbrEmprunt() == 3) return false;
		
		for(CD cd : cds) {
			if(cd.getEmprunteur() == m ) {
				if(cd.doitEtreRendu()) return false;
			}
		}
		
		return true;
	}
	
	public void emprunter (Membre m, CD cd) {
		if(cd.getEmprunteur() == null && peutEmprunter(m)) {
			cd.emprunter(m);
			membres.add(m);
		}
	}
	
	public Set<CD> chercherParArtiste(String artiste){
		Set<CD> trierParArtiste = new HashSet<CD>();
			
		for(CD cd : this.cds) {
			if(cd.getArtiste() == artiste) trierParArtiste.add(cd);
		}
		
		return trierParArtiste;
	}
	
	public Set<CD> chercherParMotCle(String motsClesDansLeTitre){
		Set<CD> trierParMotCleTitre = new HashSet<CD>();
		
		for(CD cd : this.cds) {
			if(cd.getTitre().contains(motsClesDansLeTitre)) trierParMotCleTitre.add(cd);
		}
		
		return trierParMotCleTitre;
	}

}
