package surveillanceDroneIntruder;

import java.util.Random;
import java.util.Scanner;

public class FonctionSimulation {
	
	private World world;
	private Scanner scan = new Scanner(System.in);
	private Random rand = new Random();
	
	public FonctionSimulation() {
		this.world = new World(0, 0);
	}
	
	public void affichageSimulation() {
		world.afficheWorld();
	}
	
	public void menu() {
		clearTerminal();
		char check = ' ';
		int choix = -1;
		
		System.out.println(" _____   _                   _                  _          _     _                         __     ___                            _   _   _                          \r\n"
				+ " |_   _| | |_    ___     ___ (_)  _ __    _  _  | |  __ _  | |_  (_)  ___   _ _      ___   / _|   / __|  _  _   _ _  __ __  ___  (_) | | | |  __ _   _ _    __   ___ \r\n"
				+ "   | |   | ' \\  / -_)   (_-< | | | '  \\  | || | | | / _` | |  _| | | / _ \\ | ' \\    / _ \\ |  _|   \\__ \\ | || | | '_| \\ V / / -_) | | | | | | / _` | | ' \\  / _| / -_)\r\n"
				+ "   |_|   |_||_| \\___|   /__/ |_| |_|_|_|  \\_,_| |_| \\__,_|  \\__| |_| \\___/ |_||_|   \\___/ |_|     |___/  \\_,_| |_|    \\_/  \\___| |_| |_| |_| \\__,_| |_||_| \\__| \\___|\r\n"
				+ "                                                                                                                                                                     ");
		
		System.out.println();
		
		do {
			System.out.println("\nAppuyer sur [q] pour commencer\n");
			try {
				check = scan.next().charAt(0);
			}catch(Exception e) {
				check = ' ';
			}
		}while(check != 'q');
		
		do {
			clearTerminal();
			
			System.out.println("[1] World_test");
			System.out.println("[2] World_1");
			System.out.println("\nEntrez le numéro de la map souhaite\n");
			try {
				choix = scan.nextInt();
			}catch(Exception e) {
				choix = -1;
			}
		}while(choix < 1 || choix > 2);
		
		if(choix == 1) {
			this.world = FonctionFichier.initWorld("World_test");
		}else {
			this.world = FonctionFichier.initWorld("World_1");
		}
		
	}
	
	public void simulation() {
		menu();
	
		char check = ' ';
		int nbrTour = 0;
		while(!world.getIntruders().isEmpty()) {
			
			System.out.println("Liste Intruders : " + world.getIntruders().size());
			System.out.println("Nombre de sac intruders : " + world.getIntruders().get(0).getNbrSourceArgent());
			System.out.println("Attraper source d'argent : " + world.getIntruders().get(0).isAttraperSourceArgent());
			System.out.println("Sur stock d'argent : " + world.getIntruders().get(0).isSurStockArgent());
			
			clearTerminal();
			System.out.println("Tour n°" + nbrTour);
			affichageSimulation();
			System.out.println("Liste Drone : " + world.getDrones().size());
			System.out.println("Liste Drone : " + world.getIntruders().size());
			
			for(Drone drone : world.getDrones()) {
				System.out.println("Drone :" + drone.getPosX() + " " + drone.getPosY());
				do {
					System.out.println("\nAppuyer sur [q] pour continuer\n");
					try {
						check = scan.next().charAt(0);
					}catch(Exception e) {
						check = ' ';
					}
				}while(check != 'q');
			
				world.deplacementDrone(drone);
				//world.peuxAttraperIntru(drone);
				
				System.out.println("Drone :" + drone.getPosX() + " " + drone.getPosY());
			}
			
			clearTerminal();
			System.out.println("Tour n°" + nbrTour);
			affichageSimulation();
			System.out.println("Liste Drone : " + world.getDrones().size());
			System.out.println("Liste Intruder : " + world.getIntruders().size());
			int i = 0;
			for(Intruder intruder : world.getIntruders()) {
				System.out.println("Intruder N°" + i + ":" + intruder.getPosX() + " " + intruder.getPosY());
				do {
					System.out.println("\nAppuyer sur [q] pour continuer\n");
					try {
						check = scan.next().charAt(0);
					}catch(Exception e) {
						check = ' ';
					}
				}while(check != 'q');
				world.deplacementIntruder(intruder);
				world.deplacementIntruderVersSortie(intruder);
				i++;
			}
			
			nbrTour++;
		}
		
		System.out.println();
		System.out.println("Bravo !!");
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