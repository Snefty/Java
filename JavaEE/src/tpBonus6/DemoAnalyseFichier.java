package tpBonus6;

public class DemoAnalyseFichier {
	
	public static void main(String[] args) {
		AnalyseTexte aT = new AnalyseTexte();
		aT.LireFichier("texteDemo");
		aT.afficherMap();
		aT.supprimeUnMot("bien");
		System.out.println();
		aT.afficherMap();
		
		System.out.println("\nLe nombre d'occurence pour le mot /Bonjour/ = " + aT.nbrOccurences("Bonjour") + "\n");
		aT.lesPlusFrequents();
		System.out.println("\nNombre de mot différent : " + aT.retourneNbrMotDifferent());
	}
	
}
