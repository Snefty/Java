package tpBonus7;

import java.util.ArrayList;
import java.util.List;

public class Note {

	private Matiere mat;
	private List<Double> notes;
	
	public Note(Matiere mat, double result) {
		this.mat = mat;
		notes = new ArrayList<Double>();
		ajouterNotes(result);
	}
	
	public double calculerMoyenne() {
		double moy = 0.0;
		for(Double d : this.notes) {
			moy += d;
		}
		return moy/notes.size();
	}
	
	public boolean ajouterNotes(double result) {
		return this.notes.add(result);
	}
	
	public boolean supprimerNotes(double result) {
		return this.notes.add(result);
	}

	public Matiere getMat() {
		return mat;
	}

	public List<Double> getNotes() {
		return notes;
	}
	
	public String toString() {
		String a = "";
		
			for(Double db : this.notes) {
				a += " -> " + db + "/20 \n";
			}
		
		return a;
	}
	
}
