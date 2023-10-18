package MasterMind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class fonctions {

	private final int NBR_ESSAI = 4;
	private final int NBR_MAX_COMBI = 4;
	private Random rand = new Random();

	private int[] combiSecret;
	private char[] combiTrouve;

	public fonctions() {
		this.combiSecret = new int[NBR_MAX_COMBI];
		this.combiTrouve = new char[NBR_MAX_COMBI];

		for(int i=0; i<combiSecret.length; i++) {
			combiSecret[i] = rand.nextInt(9)+1;
		}

		for(int i=0; i<combiTrouve.length ;i++) {
			combiTrouve[i] = '?';
		}
	}

	public void afficherCombinaisonSecret() {
		for(int i : this.combiSecret) {
			System.out.print("["+i + "] ");
		}
		System.out.println();
	}

	public void afficherCombinaisonTrouve() {
		for(char i : this.combiTrouve) {
			System.out.print("["+i + "] ");
		}
		System.out.println();
	}

	public int[] entreUtilisateur() {
		int[] essai = new int[this.NBR_MAX_COMBI];
		int choix = 0;

		Scanner scan = new Scanner(System.in);
		for(int i = 0 ;i<essai.length ;i++) {
			do {
				System.out.println("Entrez un numéro entre 1 et 9 ?");
				try {
					choix = scan.nextInt();
				}catch(Exception e) {
					choix = 0;
				}
			}while(choix < 1 || choix > 9);

			essai[i] = choix;
		}

		scan.close();

		return essai;
	}

	public void game() {
		int[] essai = new int[this.NBR_MAX_COMBI];

		int nbrEssai = 0;

		while(nbrEssai != this.NBR_ESSAI) {
			clearTerminal();
			this.afficherCombinaisonTrouve();

			for(int i : this.combiSecret) {
				System.out.print("["+i + "] ");
			}

			System.out.println("\nNombre de chiffre à leur place : " + nbrChiffreALeurPlace(essai));
			System.out.println("Nombre present mais pas à la bonne place : " );

			essai = entreUtilisateur();

		}

		if(nbrEssai == this.NBR_ESSAI) {
			System.out.println("Perdu, nombre d'essai epuisé !! \n");
			System.out.println("Le combinaison secrete est : ");
			this.afficherCombinaisonSecret();
		}else {
			System.out.println("GAGNER !!");
		}
	}

	private int nbrChiffreALeurPlace(int[] essai) {
		int nbr = 0;

		for(int i  = 0; i<this.combiSecret.length ;i++) {
			if(combiSecret[i] == essai[i]) nbr++;
		}

		return nbr;
	}

	private List<Integer> nbrPresentPasBonnePlace(int[] essai){
		List<Integer> nbrP = new ArrayList<Integer>();

		for(int i  = 0; i<essai.length ;i++) {
			for(int idx = 0; idx<this.combiSecret.length; i++) {
				
			}
		}

		return nbrP;
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
