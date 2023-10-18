package tpBonus6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
	
	/**
	 * Aider d'internet
	 * 
	 * Creation d'une Map qui trie les plus frequents au moins frequent
	 * 
	 * .stream : permet de traiter une map comme un éléments
	 * .sorted : permet de trier les éléments selon les paramètre donné
	 * 			- Map.Entry.comparingByValue() -> ressort les éléments du plus petit au plus grand
	 * 			- Map.Entry.comparingByValue(Collections.reverseOrder()) -> ressort les éléments du plus grand au plus petit
	 * .collect : permet de collecter les éléments qui ont etais trier, pour les mettre dans une Map
	 * 			- Collectors.toMap -> prècise le type de retour qu'on veut
	 * 			- Map.Entry::getKey et Map.Entry::getValue -> la clé et la valeur 
	 * 			 ( :: ou double colon == expresion lambda)
	 * 
	 * @return Map<String, Integer> lesPlusFrequentauMoinsFrequent
	 */
	public Map<String, Integer> lesPlusFrequents() {
		Map<String, Integer> lPF = this.occurence.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
		
		Iterator<Entry<String, Integer>> e = lPF.entrySet().iterator();
		
		for(int i = 0 ; i< 4 ; i++) {
			String a = e.next().getKey();
			System.out.println(" -> " + a + " : " + lPF.get(a));
		}
		
		return lPF;
	}
	
	public int retourneNbrMotDifferent() {
		return this.occurence.size();
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
