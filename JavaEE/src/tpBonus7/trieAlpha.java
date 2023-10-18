package tpBonus7;

import java.util.Comparator;

public class trieAlpha implements Comparator<Etudiant> {
	
	@Override
	public int compare(Etudiant o1, Etudiant o2) {
		if(o1.getIdentite().getNom().equals(o2.getIdentite().getNom())) return 0;
		int max = 0;
		if(o1.getIdentite().getNom().length() > o2.getIdentite().getNom().length()) max = o1.getIdentite().getNom().length();
		else max = o2.getIdentite().getNom().length();
		
		int i = 0;
		while(i != max) {
			if(o1.getIdentite().getNom().charAt(i)>o2.getIdentite().getNom().charAt(i)) return 1;
			if(o1.getIdentite().getNom().charAt(i)<o2.getIdentite().getNom().charAt(i)) return -1;
			i++;
		}
		return 0;
	}

}
