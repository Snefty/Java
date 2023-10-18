package tpBonus5;

import java.util.HashMap;
import java.util.Map;

public class GénéalogieDemo {
	
	public static void main(String[] args) {
		
		Map<Personne, Personne> peres = new HashMap<>();
		Map<Personne, Personne> meres = new HashMap<>();
		
		//Key = les enfants 
		//Value = les parents
		
		//Garçon
		Personne p1 = new Personne("Hollyday","Tom", Genre.HOMME);
		Personne p2 = new Personne("Hollyday","Tomy",Genre.HOMME);
		Personne p3 = new Personne("Hollyday","Alex",Genre.HOMME);
		Personne p4 = new Personne("Hollyday","Jean",Genre.HOMME);
		
		//Fille
		Personne p5 = new Personne("Hollyday","Alexia", Genre.FEMME);
		Personne p6 = new Personne("Hollyday","Julie",Genre.FEMME);
		Personne p7 = new Personne("Hollyday","Adria",Genre.FEMME);
		Personne p8 = new Personne("Hollyday","Miki",Genre.FEMME);
		
		//Tom pére de Tomy et de Alexia
		peres.put(p2, p1);
		peres.put(p5, p1);
		
		//Le pére de Tom est Jean
		peres.put(p1, p4);
		
		//Tom est marié avec Julie
		meres.put(p2, p6);
		meres.put(p5, p6);
		
		//Les parent de Julie sont Alex et Adria
		peres.put(p6, p3);
		meres.put(p6, p7);
		
		//Les grands parents de Julie sont Jean et Miki
		meres.put(p7, p8);
		peres.put(p7, p4);
		
		Genealogie g = new Genealogie(peres, meres);
		System.out.println("Afficher les fils de Tom :");
		System.out.println(g.fils(p1).toString());
		
		System.out.println();
		System.out.println("Liste des aieux de Tomy");
		System.out.println(g.aieux(p2));
		
		System.out.println();
		System.out.println("Tomy et Julie ont des aieux en commun");
		System.out.println(g.isAieuxCommun(p2,p6));
		
		System.out.println();
		System.out.println("Liste des femmes qui n'ont eu que des filles");
		System.out.println(g.isMotherQueDesFille());
	}
	
}
