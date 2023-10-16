package tpProjetAllumettes;

import java.util.Scanner;

public class Joueur {

	public int propositionJoueur() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entrez le nombre d'allumettes à retirer (1->3)");
		int num = 0;

		do {
				num = scan.nextInt();	
		}while(num != 1 && num != 2 && num != 3);
		
		return num;
	}

}
