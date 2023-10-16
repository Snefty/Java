package tp7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Paquet {

	private final Scanner scan = new Scanner(System.in);
	private Carte[] paquetDeCarte;
	private Random rand = new Random();
	private int max;

	public Paquet(Carte[] paquetDeCarte) {
		this.paquetDeCarte = paquetDeCarte;
		this.max = paquetDeCarte.length;
	}

	public Paquet() {
		paquetDeCarte = new Carte[52];
		this.max = this.paquetDeCarte.length;
		remplirPaquet();
	}

	public void afficherPaquet() {
		System.out.println();
		for(int i=0; i<paquetDeCarte.length ;i++) {
			System.out.println(paquetDeCarte[i]);
		}
	}

	public void remplirPaquet() {
		int idx = 0;
		for(int couleur = 0; couleur<4 ;couleur++) {
			for(int rang = 0 ; rang < 13 ;rang++) {
				this.paquetDeCarte[idx] = new Carte(Couleur.values()[couleur], Rang.values()[rang]);
				idx++;
			}
		}
	}

	public void mélangerPaquet() {
		List<Carte> list = Arrays.asList(this.paquetDeCarte);
		Collections.shuffle(list);
		int idx=0;
		for(Carte carte : list) {
			this.paquetDeCarte[idx] = carte;
			idx++;
		}
	}

	public Carte piocheCarte() {
		int idx = rand.nextInt(max);

		Carte other = this.paquetDeCarte[idx]; 
		this.paquetDeCarte[idx] = null;
		idx = 0;
		max--;
		Carte[] otherPaquet = new Carte[this.max];
		for(Carte carte : this.paquetDeCarte) {
			if(carte != null) {
				otherPaquet[idx] = carte;
				idx++;
			}
		}

		this.paquetDeCarte = otherPaquet;	
		return other;
	}

	public boolean verifietirragePossible(Player pl1, Player pl2) {
		if(pl1.isPlayerPlusDeCarte() || pl2.isPlayerPlusDeCarte()) return false;
		else return true;
	}

	public void game(String namePlayer1, String namePlayer2) {
		remplirPaquet();
		mélangerPaquet();

		Player pl1 = new Player(namePlayer1);
		Player pl2 = new Player(namePlayer2);

		for(int i=0; i<26 ;i++) {
			pl1.ajouterCarte(piocheCarte());
		}

		for(int i=0; i<26 ;i++) {
			pl2.ajouterCarte(piocheCarte());
		}

		char check = ' ';

		do {
			clearTerminal();

			System.out.println(pl1.getSpeudo() + " VS " + pl2.getSpeudo());
			System.out.println();

			System.out.println("\nappuyer [q] pour lancer la partie\n");
			try {
				check = scan.next().charAt(0);
			}catch(Exception e) {
				check = ' ';
			}
		}while(check != 'q');

		Carte c1 = new Carte();
		Carte c2 = new Carte();
		int tour = 0;
		boolean etat = false;
		PlayerRankingComparator pRC = new PlayerRankingComparator();

		List<Carte> tmp = new ArrayList<Carte>();

		do {
			clearTerminal();

			if(verifietirragePossible(pl1, pl2)) {

				c1 = pl1.tirerCarte();
				c2 = pl2.tirerCarte();

				System.out.println("Tour n°" + tour + "\n");
				System.out.println(pl1.getSpeudo() + " / Carte deck principal : " +pl1.getCartes().size());
				System.out.println(pl1.getSpeudo() + " / Carte gagner : " +pl1.getCartesGagner().size());
				System.out.println(pl2.getSpeudo() + " / Carte deck principal : " +pl2.getCartes().size());
				System.out.println(pl2.getSpeudo() + " / Carte gagner : " +pl2.getCartesGagner().size());
				System.out.println(pl1.getCartes().size() + pl2.getCartes().size() + pl1.getCartesGagner().size() + pl2.getCartesGagner().size()+2);
				System.out.println();
				System.out.println(c1 + " / " + c2);

				//demandeEntre();

				if(pRC.compare(c1, c2) == 1) {
					pl1.ajouterCarteGagner(c1);
					pl1.ajouterCarteGagner(c2);
				}else if(pRC.compare(c1, c2) == -1) {
					pl2.ajouterCarteGagner(c1);
					pl2.ajouterCarteGagner(c2);
				}else {
					System.out.println();
					System.out.println("Bataille !!!");

					demandeEntre();

					tmp.add(c1);
					tmp.add(c2);
					
					etat = false;
					
					while(!etat) {
						
						if(verifietirragePossible(pl1, pl2)) {
							//Carte face caché
							tmp.add(pl1.tirerCarte());
							tmp.add(pl2.tirerCarte());

							System.out.println("carteCaché / carteCaché");

							if(verifietirragePossible(pl1, pl2)) {
								//Carte sur les cartes face caché
								c1 = pl1.tirerCarte();
								tmp.add(c1);
								c2 = pl2.tirerCarte();
								tmp.add(c2);

								System.out.println(c1 + " / " + c2);

								if(pRC.compare(c1, c2) == 1) {
									etat = true;
									for(Carte carte : tmp) {
										pl1.ajouterCarteGagner(carte);
									}

									System.out.println("Gagnant :" + pl1.getSpeudo());
									demandeEntre();
								}else if(pRC.compare(c1, c2) == -1) {
									etat = true;
									for(Carte carte : tmp) {
										pl2.ajouterCarteGagner(carte);
									}

									System.out.println("Gagnant :" + pl2.getSpeudo());
									demandeEntre();
								}else {
									System.out.println("Egalité !!");
								}

							}else {
								etat = true;
							}
						}else {
							etat = true;
						}
						
					}
					etat = false;
					tmp.clear();
				}

				tour++;
			}



		}while(pl1.isPlayerPlusDeCarte() != true && pl2.isPlayerPlusDeCarte() != true);
		
		if(pl1.isPlayerPlusDeCarte()) {
			System.out.println(pl2.getSpeudo() + " gagne la bataille");
		}else if(pl2.isPlayerPlusDeCarte()) {
			System.out.println(pl1.getSpeudo() + " gagne la bataille");
		}else {
			System.out.println("Egalité !!");
		}

	}

	public void demandeEntre() {
		char check = ' ';
		do {
			System.out.println("\nprochain tour [q]\n");
			try {
				check = scan.next().charAt(0);
			}catch(Exception e) {
				check = ' ';
			}
		}while(check != 'q');
	}

	private static void clearTerminal(){
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
