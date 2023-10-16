package surveillanceDroneIntruder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FonctionFichier {

	public static World initWorld(String nameFile) {

		World world = null;

		try {

			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "maps" + File.separator + nameFile;
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";

			// Recuperation longueur et largeur
			line = br.readLine();
			world = new World(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]));

			int x = 0;
			while((line = br.readLine()) != null) {

				for(int y=0; y<line.length() ;y++) {

					//On check et on la position des Drone et intruders
					if(line.charAt(y) == Entity.Drone.getSymbole()) world.ajouterDrone(x, y);
					else if(line.charAt(y) == Entity.Intruder.getSymbole()) world.ajouterIntruder(x, y);
					else if(line.charAt(y) == Entity.Source_D_Argent.getSymbole()) world.ajouterSourceArgent(x, y);
					else {

						//Prends les indexs des sorties possible en haut du terrain
						if(x == 0 && y < world.getLongueur()) {
							if(line.charAt(y) == '_') world.ajouterindxSortie(x + " " + y);
						}else {
							if(y == 0) if(line.charAt(0) == '_') world.ajouterindxSortie(x + " " + y);
						}


						//Prends les indexs des sorties possible en bas du terrain
						if(x == world.getLargeur()-1 && y < world.getLargeur()*world.getLongueur()) {
							if(line.charAt(y) == '_') world.ajouterindxSortie(x + " " + y);
						}

						//Prends les index des sortie possible sur les cotés
						if(y == line.length()-1)if(line.charAt(line.length()-1) == '_') world.ajouterindxSortie(x + " " + y);

					}

					world.ajouterChar(line.charAt(y), x,y);
				}
				x++;

			}

			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("Fichier introuvable !!");
		}catch(IOException e) {
			e.printStackTrace();
		}

		return world;
	}

	public static int afficherFichierMaps(){
		File dir = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "maps");
		File[] list = dir.listFiles();
		int nbrFichier = 0;
		for(File item : list){
			if(item.isFile())
			{ 
				System.out.format("["+ nbrFichier + "]  -> %s\n", item.getName()); 
				nbrFichier++;
			} 
		}
		return nbrFichier;
	}
	
	public static World initierMap(int i) {
		File dir = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "maps");
		File[] list = dir.listFiles();
		int nbrFichier = 0;
		for(File item : list){
			if(nbrFichier == i)
			{ 
				return initWorld(item.getName());
			} 
			nbrFichier++;
		}
		
		return initWorld("World_1");
	}

}