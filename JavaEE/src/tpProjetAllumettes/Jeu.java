package tpProjetAllumettes;

import java.io.IOException;
import java.util.Scanner;

public class Jeu {

	Scanner scan = new Scanner(System.in);
	int nbAllumettes;

	public Jeu() {
		this.nbAllumettes = 17;
	}

	public void afficherAllumettes() {
		for(int i=0; i<nbAllumettes ;i++) {
			System.out.print("|");
		}
		System.out.println();
	}

	public void commencerJeu() {
		Joueur player = new Joueur();
		Ordinateur ordi = new Ordinateur();
		int prop = 0;
		int idx= 0;

		while(nbAllumettes > 0) {
			clearTerminal();
			System.out.println("             (งツ)ว                   ");
			System.out.println("L'ordinateur choisi le nombre " + prop);
			afficherAllumettes();
			prop = player.propositionJoueur();
			nbAllumettes -= prop;
			idx = 1;

			if(nbAllumettes > 0) {
				prop = ordi.propositionOrdinateur();
				
				nbAllumettes -= prop;
				idx = 2;
			}
			clearTerminal();
		}

		clearTerminal();
		if(idx == 1) {
			System.out.println("Bravo player à gagner");
		}else {
			System.out.println("Perdu l'ordinateur à gagner");
		}
	}

	public void menuJeu() {
		int idx=0;

		do {
			clearTerminal();
			System.out.println("Jeu des allumettes");

			System.out.println("Appuyez-sur [1] pour lancer une partie");
			idx = scan.nextInt();
		}while(idx != 1);

		int nbrAllu = 0;

		do {
			clearTerminal();
			System.out.println("Insérer le nombre d'allumette");
			nbrAllu = scan.nextInt();
		}while(nbrAllu <= 0);

		setNbAllumettes(nbrAllu);

		commencerJeu();
	}

	public void setNbAllumettes(int nbAllumettes) {
		this.nbAllumettes = nbAllumettes;
	}

	private void clearTerminal(){
		for (int i = 0; i < 40; ++i) System.out.println();
		/*try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
