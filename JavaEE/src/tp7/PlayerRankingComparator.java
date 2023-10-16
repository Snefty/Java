package tp7;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Carte>{

	@Override
	public int compare(Carte o1, Carte o2) {
			//Player 1 gagne
		if(o1.getRang().getNbforce() > o2.getRang().getNbforce()) return 1;
			//Player 2 gagne
		else if(o1.getRang().getNbforce() < o2.getRang().getNbforce()) return -1;
			//Egalité 
		return 0;
	}

}
