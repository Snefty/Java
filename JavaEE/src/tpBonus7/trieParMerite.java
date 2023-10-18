package tpBonus7;

import java.util.Comparator;

public class trieParMerite implements Comparator<Etudiant>{

	@Override
	public int compare(Etudiant o1, Etudiant o2) {
		if(o1.calculeMoyenneGlobal()>o2.calculeMoyenneGlobal()) return -1;
		if(o1.calculeMoyenneGlobal()<o2.calculeMoyenneGlobal()) return 1;
		return 0;
	}

}
