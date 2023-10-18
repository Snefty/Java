package tpBonus7;

import java.util.Comparator;

public class triParMatiere implements Comparator<Etudiant>{

	private Matiere mat;

	public triParMatiere(Matiere mat) {
		this.mat = mat;
	}
	
	@Override
	public int compare(Etudiant o1, Etudiant o2) {
		if(o1.calculerMoyenneMatiere(mat) > o2.calculerMoyenneMatiere(mat)) return -1;
		if(o1.calculerMoyenneMatiere(mat) < o2.calculerMoyenneMatiere(mat)) return 1;
		return 0;
	}

}
