package tpBonus7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Groupe {
	
	private List<Etudiant> etudiants;
	private Formation formation;
	
	public Groupe(Formation formation) {
		this.formation = formation;
		this.etudiants = new ArrayList<Etudiant>();
	}
	
	public void ajouterEtudiant(String nip, String nom, String prenom) {
		etudiants.add(new Etudiant(nip, nom, prenom, this.formation));
	}
	
	public void supprimerEtudiant(int nb) {
		etudiants.remove(nb);
	}
	
	public double calculerMoyenneGroupeParMatiere(Matiere mat) {
		double moy = 0.0;
		
			for(Etudiant e : this.etudiants) {
				moy += e.calculerMoyenneMatiere(mat);
			}
		
		return moy/this.etudiants.size();
	}
	
	public double calculerMoyenneGroupe() {
		double moy = 0.0;
		
			for(Etudiant e : this.etudiants) {
				moy += e.calculeMoyenneGlobal();
			}
		
		return moy/this.etudiants.size();
	}
	
	public List<Etudiant> triParMerite(){
		List<Etudiant> etudiantTrie = this.etudiants;
		Collections.sort(etudiantTrie, new trieParMerite());
		return etudiantTrie;
	}
	
	public List<Etudiant> triAlpha(){
		List<Etudiant> etudiantTrie = this.etudiants;
		Collections.sort(etudiantTrie, new trieAlpha());
		return etudiantTrie;
	}

	public List<Etudiant> triParMatière(Matiere mat){
		List<Etudiant> etudiantTrie = this.etudiants;
		Collections.sort(etudiantTrie, new triParMatiere(mat));
		return etudiantTrie;
	} 
	
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	
	public String toString() {
		String a = "Le groupe de la formation : " + this.formation.getId() + "\n";
			
			for(Etudiant e : this.etudiants) {
				a += e;
			}
		
		return a;
	}
	
}
