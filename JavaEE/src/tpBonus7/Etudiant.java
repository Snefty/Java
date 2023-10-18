package tpBonus7;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
	
	private Identite identite;
	private Formation formation;
	private List<Note> resultats;
	
	public Etudiant(String nip, String nom, String prenom, String idFormation) {
		this.identite = new Identite(nip, nom, prenom);
		this.formation = new Formation(idFormation);
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
	
	public String toString() {
		
	}
	
}
