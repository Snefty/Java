package surveillanceDroneIntruder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {

	private char[][] plateau;
	private int largeur;
	private int longueur;

	//Permet de connaitre les soprties 
	private List<String> indxSortie;

	private List<Drone> Drones;
	private List<Intruder> Intruders;
	private List<Argent> source_DArgent;

	private Random rand = new Random();

	public World(int largeur, int longeur) {
		this.largeur = largeur;
		this.longueur = longeur;
		this.plateau = new char[largeur][longueur];
		this.indxSortie = new ArrayList<>();
		this.Intruders = new ArrayList<>();
		this.Drones = new ArrayList<>();
		this.source_DArgent = new ArrayList<Argent>();
	}

	public void afficheWorld() {
		for(int x = 0; x<this.largeur ;x++) {
			for(int y = 0; y<this.longueur ;y++) {
				System.out.print(this.plateau[x][y] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * 	[1][2][3]		[D][2][3]
	 * 	[8][D][4]  ->   [8][1][4]
	 * 	[7][6][5]		[7][6][5]
	 *
	 */

	public void deplacementDrone(Drone entite) {

		int choix = 0;

		do {
			try {
				choix = rand.nextInt(8)+1;
				System.out.println("intérieur boucle choix = " + choix);
			}catch(Exception e) {
				choix = 0;
			}
		}while(!deplacementPossible(entite, choix));


		System.out.println(deplacementPossible(entite, choix));
		System.out.println(choix);

		int x = entite.getPosX();
		int y = entite.getPosY();

		if( choix == 1) {

			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[x-1][y-1] = entite.getGenre().getSymbole();
				entite.modifierPos(x-1, y-1);

			}else {
				if(plateau[x-1][y-1] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x-1][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y-1);
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x-1][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y-1);
				}
			}



		}else if(choix == 2){

			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[entite.getPosX()-1][entite.getPosY()] = entite.getGenre().getSymbole();
				entite.modifierPos(entite.getPosX()-1, entite.getPosY());

			}else {
				if(plateau[entite.getPosX()-1][entite.getPosY()] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()-1][entite.getPosY()] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()-1, entite.getPosY());
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()-1][entite.getPosY()] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()-1, entite.getPosY());
				}
			}



		}else if(choix == 3){

			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[entite.getPosX()-1][entite.getPosY()+1] = entite.getGenre().getSymbole();
				entite.modifierPos(entite.getPosX()-1, entite.getPosY()+1);

			}else {
				if(plateau[entite.getPosX()-1][entite.getPosY()+1] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()-1][entite.getPosY()+1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()-1, entite.getPosY()+1);
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()-1][entite.getPosY()+1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()-1, entite.getPosY()+1);
				}
			}



		}else if(choix == 4){

			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[entite.getPosX()][entite.getPosY()+1] = entite.getGenre().getSymbole();
				entite.modifierPos(entite.getPosX(), entite.getPosY()+1);

			}else {
				if(plateau[entite.getPosX()][entite.getPosY()+1] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()][entite.getPosY()+1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX(), entite.getPosY()+1);
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()][entite.getPosY()+1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX(), entite.getPosY()+1);
				}
			}


		}else if(choix == 5){


			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[entite.getPosX()+1][entite.getPosY()+1] = entite.getGenre().getSymbole();
				entite.modifierPos(entite.getPosX()+1, entite.getPosY()+1);

			}else {
				if(plateau[entite.getPosX()+1][entite.getPosY()+1] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()+1][entite.getPosY()+1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()+1, entite.getPosY()+1);
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()+1][entite.getPosY()+1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()+1, entite.getPosY()+1);
				}
			}


		}else if(choix == 6){


			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[entite.getPosX()+1][entite.getPosY()] = entite.getGenre().getSymbole();
				entite.modifierPos(entite.getPosX()+1, entite.getPosY());

			}else {
				if(plateau[entite.getPosX()+1][entite.getPosY()] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()+1][entite.getPosY()] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()+1, entite.getPosY());
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()+1][entite.getPosY()] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()+1, entite.getPosY());
				}
			}


		}else if(choix == 7){

			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[entite.getPosX()+1][entite.getPosY()-1] = entite.getGenre().getSymbole();
				entite.modifierPos(entite.getPosX()+1, entite.getPosY()-1);

			}else {
				if(plateau[entite.getPosX()+1][entite.getPosY()-1] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()+1][entite.getPosY()-1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()+1, entite.getPosY()-1);
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()+1][entite.getPosY()-1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX()+1, entite.getPosY()-1);
				}
			}

		}else if(choix == 8){

			if(entite.isSurStockArgent()) {

				entite.setSurStockArgent(false);
				plateau[x][y] = Entity.Source_D_Argent.getSymbole();
				plateau[entite.getPosX()][entite.getPosY()-1] = entite.getGenre().getSymbole();
				entite.modifierPos(entite.getPosX(), entite.getPosY()-1);

			}else {
				if(plateau[entite.getPosX()][entite.getPosY()-1] == Entity.Case_Vide.getSymbole()) {
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()][entite.getPosY()-1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX(), entite.getPosY()-1);
				}else {
					entite.setSurStockArgent(true);
					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[entite.getPosX()][entite.getPosY()-1] = entite.getGenre().getSymbole();
					entite.modifierPos(entite.getPosX(), entite.getPosY()-1);
				}
			}
		}


		entite.setEstTourPassé(true);
	}

	// A REFAIRE
	public void deplacementIntruder(Intruder entite) {
			
		if(entite.getNbrSourceArgent() == entite.getNbrSourceArgent()) {
			deplacementIntruderVersSortie(entite);
		}
		
		int choix = 0;

		do {
			try {
				choix = rand.nextInt(8)+1;
				System.out.println("intérieur boucle choix = " + choix);
			}catch(Exception e) {
				choix = 0;
			}
		}while(!deplacementPossible(entite, choix));


		System.out.println(deplacementPossible(entite, choix));
		System.out.println(choix);

		int x = entite.getPosX();
		int y = entite.getPosY();

		if( choix == 1) {

			if(entite.isSurStockArgent()) {
				if(plateau[x-1][y-1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x-1][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y-1);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x-1][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y-1);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x-1][y-1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x-1][y-1] = entite.getGenre().getSymbole();
				entite.modifierPos(x-1, y-1);
				entite.setAttraperSourceArgent(false);
			}

		}else if(choix == 2){

			if(entite.isSurStockArgent()) {
				if(plateau[x-1][y] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x-1][y] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x-1][y] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x-1][y] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x-1][y] = entite.getGenre().getSymbole();
				entite.modifierPos(x-1, y);
				entite.setAttraperSourceArgent(false);
			}


		}else if(choix == 3){

			if(entite.isSurStockArgent()) {
				if(plateau[x-1][y+1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x-1][y+1] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y+1);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x-1][y+1] = entite.getGenre().getSymbole();
					entite.modifierPos(x-1, y+1);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x-1][y+1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x-1][y+1] = entite.getGenre().getSymbole();
				entite.modifierPos(x-1, y+1);
				entite.setAttraperSourceArgent(false);
			}

		}else if(choix == 4){

			if(entite.isSurStockArgent()) {
				if(plateau[x][y+1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x][y+1] = entite.getGenre().getSymbole();
					entite.modifierPos(x, y+1);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x][y+1] = entite.getGenre().getSymbole();
					entite.modifierPos(x, y+1);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x][y+1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x][y+1] = entite.getGenre().getSymbole();
				entite.modifierPos(x, y+1);
				entite.setAttraperSourceArgent(false);
			}

		}else if(choix == 5){

			if(entite.isSurStockArgent()) {
				if(plateau[x+1][y+1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x+1][y+1] = entite.getGenre().getSymbole();
					entite.modifierPos(x+1, y+1);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x+1][y+1] = entite.getGenre().getSymbole();
					entite.modifierPos(x+1, y+1);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x+1][y+1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x+1][y+1] = entite.getGenre().getSymbole();
				entite.modifierPos(x+1, y+1);
				entite.setAttraperSourceArgent(false);
			}

		}else if(choix == 6){

			if(entite.isSurStockArgent()) {
				if(plateau[x+1][y] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x+1][y] = entite.getGenre().getSymbole();
					entite.modifierPos(x+1, y);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x+1][y] = entite.getGenre().getSymbole();
					entite.modifierPos(x+1, y);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x+1][y] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x+1][y] = entite.getGenre().getSymbole();
				entite.modifierPos(x+1, y);
				entite.setAttraperSourceArgent(false);
			}

		}else if(choix == 7){

			if(entite.isSurStockArgent()) {
				if(plateau[x+1][y-1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x+1][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x+1, y-1);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x+1][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x+1, y-1);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x+1][y-1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x+1][y-1] = entite.getGenre().getSymbole();
				entite.modifierPos(x+1, y-1);
				entite.setAttraperSourceArgent(false);
			}

		}else if(choix == 8){

			if(entite.isSurStockArgent()) {
				if(plateau[x][y-1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				if(!entite.isAttraperSourceArgent() && !entite.possibleRecup()) {

					plateau[x][y] = Entity.Case_Vide.getSymbole();
					plateau[x][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x, y-1);
					entite.setNbrSourceArgent(1);
					entite.setAttraperSourceArgent(true);

				}else {

					plateau[x][y] = Entity.Source_D_Argent.getSymbole();
					plateau[x][y-1] = entite.getGenre().getSymbole();
					entite.modifierPos(x, y-1);
					entite.setAttraperSourceArgent(false);
				}

			}else {

				if(plateau[x][y-1] == Entity.Source_D_Argent.getSymbole()) {
					entite.setSurStockArgent(true);
				}else {
					entite.setSurStockArgent(false);
				}

				plateau[x][y] = Entity.Case_Vide.getSymbole();
				plateau[x][y-1] = entite.getGenre().getSymbole();
				entite.modifierPos(x, y-1);
				entite.setAttraperSourceArgent(false);
			}

		}

		entite.setEstTourPassé(true);
	}

	/*
	 * 	[1][2][3]		[D][2][3]
	 * 	[8][D][4]  ->   [8][1][4]
	 * 	[7][6][5]		[7][6][5]
	 *
	 */
	public boolean deplacementPossible(Bot entite, int choix) {
		if( choix == 1 && (entite.getPosX()-1) > 0 && (entite.getPosY()-1) > -1 && plateau[entite.getPosX()-1][entite.getPosY()-1] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()-1][entite.getPosY()-1] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()-1][entite.getPosY()-1] != Entity.Intruder.getSymbole()) {
			return true;

		}else if(choix == 2  && (entite.getPosX()-1) > -1 && plateau[entite.getPosX()-1][entite.getPosY()] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()-1][entite.getPosY()] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()-1][entite.getPosY()] != Entity.Intruder.getSymbole()){
			return true;

		}else if(choix == 3  && (entite.getPosX()-1) > -1 && (entite.getPosY()+1) < this.longueur  && plateau[entite.getPosX()-1][entite.getPosY()+1] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()-1][entite.getPosY()+1] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()-1][entite.getPosY()+1] != Entity.Intruder.getSymbole()){
			return true;

		}else if(choix == 4 && (entite.getPosY()+1) < this.longueur && plateau[entite.getPosX()][entite.getPosY()+1] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()][entite.getPosY()+1] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()][entite.getPosY()+1] != Entity.Intruder.getSymbole()){
			return true;

		}else if(choix == 5 && (entite.getPosX()+1) < this.largeur && (entite.getPosY()+1) < this.longueur  && ((entite.getPosX()+1)+(entite.getPosY()+1)) < plateau.length &&  plateau[entite.getPosX()+1][entite.getPosY()+1] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()+1][entite.getPosY()+1] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()+1][entite.getPosY()+1] != Entity.Intruder.getSymbole()){
			return true;

		}else if(choix == 6 && (entite.getPosX()+1) < this.largeur &&  plateau[entite.getPosX()+1][entite.getPosY()] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()+1][entite.getPosY()] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()+1][entite.getPosY()] != Entity.Intruder.getSymbole()){
			return true;

		}else if(choix == 7 && (entite.getPosX()+1) < this.largeur && (entite.getPosY()-1) > 0 &&  plateau[entite.getPosX()+1][entite.getPosY()-1] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()+1][entite.getPosY()-1] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()+1][entite.getPosY()-1] != Entity.Intruder.getSymbole()){
			return true;

		}else if(choix == 8 && (entite.getPosY()-1) > -1 &&  plateau[entite.getPosX()][entite.getPosY()-1] != Entity.Barrière.getSymbole()
				&& plateau[entite.getPosX()][entite.getPosY()-1] != Entity.Drone.getSymbole()
				&& plateau[entite.getPosX()][entite.getPosY()-1] != Entity.Intruder.getSymbole()){
			return true;

		}

		return false;
	}
	
	/**
	 * Utiliser uniquement par les intruders pour se deplacer vers la sortie la plus proche
	 */
	public void deplacementIntruderVersSortie(Intruder e) {
		String indxSortiePlusProche = sortieLePlusProche(e);
		System.out.println("Sortie la plus proche " + indxSortiePlusProche);
	}
	
	
	
	//A REFAIRE 
	/**
	 * Permet de connaitre la sortie la plus proche d'un intruder grace a ces coordonnées 
	 * @return un String des coordonnée de la sortie la plus proche
	 */
	public String sortieLePlusProche(Intruder e) {
		String indxSortiePlusProche = this.indxSortie.get(0);
		
		int xSortie = 0;
		int ySortie = 0;
		
		for(String sortieIndex : this.indxSortie) {
			xSortie = Integer.parseInt(sortieIndex.split(" ")[0]);
			ySortie = Integer.parseInt(sortieIndex.split(" ")[1]);
			
			for(int posX=e.getPosX(); posX<this.largeur ;posX++) {
				for(int posY=e.getPosY(); posY<this.longueur ;posY++) {
					
				}
			}
			
		}
		
		return indxSortiePlusProche;
	}
	
	public boolean peuxAttraperIntru(Drone entite) {

		if(!entite.isAttraperIntruder() && !this.Intruders.isEmpty()) {
			
			if((entite.getPosX()-1) > 0 && (entite.getPosY()-1) > -1 && plateau[entite.getPosX()-1][entite.getPosY()-1] == Entity.Intruder.getSymbole()) {
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()-1][entite.getPosY()-1] = Entity.Case_Vide.getSymbole();
				supprimerIntruder(entite.getPosX()-1,entite.getPosY()-1);
				return true;

			}else if((entite.getPosX()-1) > -1 && plateau[entite.getPosX()-1][entite.getPosY()] == Entity.Intruder.getSymbole()){
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()-1][entite.getPosY()] = Entity.Case_Vide.getSymbole();
				this.Intruders.remove(new Intruder(entite.getPosX()-1, entite.getPosY()));
				return true;

			}else if((entite.getPosX()-1) > -1 && (entite.getPosY()+1) < this.longueur  && plateau[entite.getPosX()-1][entite.getPosY()+1] == Entity.Intruder.getSymbole()){
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()-1][entite.getPosY()+1] = Entity.Case_Vide.getSymbole();
				supprimerIntruder(entite.getPosX()-1,entite.getPosY()+1);
				return true;

			}else if((entite.getPosY()+1) < this.longueur && plateau[entite.getPosX()][entite.getPosY()+1] == Entity.Intruder.getSymbole()){
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()][entite.getPosY()+1] = Entity.Case_Vide.getSymbole();
				supprimerIntruder(entite.getPosX(),entite.getPosY()+1);
				return true;

			}else if((entite.getPosX()+1) < this.largeur && (entite.getPosY()+1) < this.longueur  && plateau[entite.getPosX()+1][entite.getPosY()+1] == Entity.Intruder.getSymbole()){
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()+1][entite.getPosY()+1] = Entity.Case_Vide.getSymbole();
				supprimerIntruder(entite.getPosX()+1,entite.getPosY()+1);
				return true;

			}else if((entite.getPosX()+1) < this.largeur && plateau[entite.getPosX()+1][entite.getPosY()] == Entity.Intruder.getSymbole()){
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()+1][entite.getPosY()] = Entity.Case_Vide.getSymbole();
				supprimerIntruder(entite.getPosX()+1,entite.getPosY());
				return true;

			}else if((entite.getPosX()+1) < this.largeur && (entite.getPosY()-1) > 0 && plateau[entite.getPosX()+1][entite.getPosY()-1] == Entity.Intruder.getSymbole()){
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()+1][entite.getPosY()-1] = Entity.Case_Vide.getSymbole();
				supprimerIntruder(entite.getPosX()+1,entite.getPosY()-1);
				return true;

			}else if((entite.getPosY()-1) > -1 && plateau[entite.getPosX()][entite.getPosY()-1] == Entity.Intruder.getSymbole()){
				entite.setAttraperIntruder(true);
				plateau[entite.getPosX()][entite.getPosY()-1] = Entity.Case_Vide.getSymbole();
				supprimerIntruder(entite.getPosX(),entite.getPosY()-1);
				return true;

			}
		}
		
		entite.setAttraperIntruder(false);
		return false;
	}

	public boolean peuxAttraperSacArgent(Intruder intruder) {
		
		
		return false;
	}
	
public boolean supprimerIntruder(int x, int y) {
		for(Intruder intruder : this.Intruders) {
			System.out.println("intruder " + intruder.getPosX() + " " + intruder.getPosY());
			System.out.println(x + " " + y);
			if(intruder.getPosX() == x && intruder.getPosY() == y) {

				this.Intruders.remove(intruder);
				return true; 
			}
		}
		return false;
	}

	public void ajouterChar(char symbole, int largeur, int longueur) {
		plateau[largeur][longueur] = symbole;
	}

	public boolean ajouterIntruder(int x, int y) {
		Intruders.add(new Intruder(x, y));
		return true;
	}

	public boolean ajouterDrone(int x, int y) {
		Drones.add(new Drone(x, y));
		return true;
	}

	public boolean ajouterSourceArgent(int x, int y) {
		this.source_DArgent.add(new Argent(x, y));
		return true;
	}

	public boolean ajouterindxSortie(String index) {
		for(String i : indxSortie) {
			if(i == index) return false;
		}
		indxSortie.add(index);
		return true;
	}

	public List<Drone> getDrones() {
		return Drones;
	}

	public List<Intruder> getIntruders() {
		return Intruders;
	}

	public List<String> getIndxSortie() {
		return indxSortie;
	}
	public int getLargeur() {
		return largeur;
	}

	public int getLongueur() {
		return longueur;
	}
}