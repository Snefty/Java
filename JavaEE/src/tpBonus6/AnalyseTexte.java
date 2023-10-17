package tpBonus6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AnalyseTexte {

	private Map<String, Integer> occurence;

	public AnalyseTexte() {
		this.occurence = new HashMap<String, Integer>();
	}

	public void ajouteUnMot(String mot) {
		if(occurence.containsKey(mot)) {
			occurence.put(mot,occurence.get(mot)+1);
		}else {
			occurence.put(mot, 1);
		}
	}

	public void supprimeUnMot(String mot) {
		if(occurence.containsKey(mot)) {
			if(occurence.get(mot) != 0) {
				occurence.put(mot, occurence.get(mot)-1);
			}
		}
	}

	public int nbrOccurences(String mot) {
		if(occurence.containsKey(mot)) return occurence.get(mot); 
		return 0;
	}

	//PAS FINIS
	public Map<String, Integer> lesPlusFrequents() {
		Map<String, Integer> lPF = new TreeMap<String, Integer>(this.occurence);

		return lPF;
	}

	public void afficherMap() {

		for(Map.Entry<String, Integer> entry : this.occurence.entrySet()) {
			System.out.println(" -> " + entry.getKey() + " : " + entry.getValue());
		}

	}

	public void LireFichier(String nameFile) {

		try {

			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "tpBonus6" + File.separator + nameFile;
			System.out.println(path);

			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";

			while((line = br.readLine()) != null) {
				String[] mot = line.split(" ");
				for(int i = 0; i<mot.length ;i++) {
					ajouteUnMot(mot[i]);
				}

			}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("Fichier introuvable !!");
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
}
