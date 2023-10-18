package tpBonus7;

import java.util.Random;

public class DemoFormation {
	
	private static Random rand = new Random();
	
	public static void main(String[] args) {
		
		Formation formation = new Formation("JAVA_EE");
		
		formation.ajouterMatiere(Matiere.ANGLAIS);
		formation.ajouterMatiere(Matiere.FRANCAIS);
		formation.ajouterMatiere(Matiere.HISTOIRE_GEOGRAPHIE);
		formation.ajouterMatiere(Matiere.MATH);
		formation.ajouterMatiere(Matiere.PHILO);
		formation.ajouterMatiere(Matiere.SCPECIALITE);
		
		System.out.println("========Formation========");
		System.out.println(formation);
		System.out.println("=========================\n");
		
		Groupe groupe = new Groupe(formation);
		groupe.ajouterEtudiant("E2", "Tom", "holland");
		groupe.ajouterEtudiant("Y3", "Greg", "MMA");
		groupe.ajouterEtudiant("N1", "Alexis", "Donnez");
		groupe.ajouterEtudiant("I5", "Jean", "MichelJaiLaRef");
		
		
		System.out.println("========Groupe========");
		System.out.println(groupe);
		System.out.println("=========================\n");
	
		//Ajouter des notes aléatoires
		for(Etudiant e : groupe.getEtudiants()) {
			for(int i=0 ;i<3 ;i++) {
				e.ajouterUneNote(Matiere.values()[i], rand.nextInt(20)+1);
			}
		}
		
		for(Etudiant e : groupe.getEtudiants()) {
			for(int i=0 ;i<3 ;i++) {
				e.ajouterUneNote(Matiere.values()[i], rand.nextInt(20)+1);
			}
		}
		
		System.out.println("========Groupe========");
		System.out.println(groupe);
		System.out.println("=========================\n");
		
		for(Etudiant e : groupe.getEtudiants()) {
				System.out.println("Moyenne générale : "+ e.calculeMoyenneGlobal());
		}
		
		System.out.println("\nTrier par merite");
		for(Etudiant e : groupe.triParMerite()) {
			System.out.println(e.getIdentite().getNom() + " " + e.calculeMoyenneGlobal());
		}
		
		System.out.println("\nTrier alphanumerique");
		for(Etudiant e : groupe.triAlpha()) {
			System.out.println(e.getIdentite().getNom());
		}
		
		System.out.println("\nTrier par Matiere : Anglais");
		for(Etudiant e : groupe.triParMatière(Matiere.ANGLAIS)) {
			System.out.println(e.getIdentite().getNom() + " " + e.calculerMoyenneMatiere(Matiere.ANGLAIS));
		}
	}
	
}
