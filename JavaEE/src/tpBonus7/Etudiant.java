package tpBonus7;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
	
	private Identite identite;
	private Formation formation;
	private List<Note> resultats;
	
	public Etudiant(String nip, String nom, String prenom, Formation formation) {
		this.identite = new Identite(nip, nom, prenom);
		this.formation = formation;
		this.resultats = new ArrayList<Note>();
	}
	
	public boolean ajouterUneNote(Matiere mat ,double note) {
		if(!resultats.isEmpty()) {
			for(Note n : resultats) {
				if(n.getMat() == mat) {
					n.ajouterNotes(note);
					return true;
				}
			}
		}
		
		resultats.add(new Note(mat, note));
		return true;
	}
	
	public double calculerMoyenneMatiere(Matiere mat) {
		for(Note n : resultats) {
			if(n.getMat() == mat) {
				return n.calculerMoyenne();
			}
		}  
		
		return 0.0;
	}
	
	public double calculeMoyenneGlobal() {
		double moyGen = 0.0;
		
		for(Note n : this.resultats) {
			moyGen += calculerMoyenneMatiere(n.getMat());
		}
		
		return moyGen/this.resultats.size();
	}
	
	public void modifierFormation(Formation formation) {
		this.resultats.clear();
		this.formation = formation;
	}
	
	public String toString() {
		String a =" -> " + this.identite + "\n";
			
		for(Note n : resultats) {
			a +=  n.getMat() + ": \n";
			a +=  n + "\n";
		}
		
		return a;
	}

	public Identite getIdentite() {
		return identite;
	}
	
}
