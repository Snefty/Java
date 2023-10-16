package tpProjetAllumettes;

import java.util.Random;

public class Ordinateur {
	
	public int propositionOrdinateur() {
		Random rand = new Random();
		int numAle = rand.nextInt(3)+1;
		
		return numAle;
	}
	
}
