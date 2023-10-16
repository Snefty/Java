package expressionArithemitque;

public class ExempleEpressionArithmetique {

	public static void main(String[] args) {
		// Premier exemple

		// on stocke l’expression ((3+2+6) * (8-7))
		Noeud racine = new OperateurMult();
		Noeud opGauche = new OperateurPlus();
		Noeud opGaucheDroite = new OperateurPlus();
		Noeud opDroite = new OperateurMoins();
		opGauche.ajouteFils(new Nombre(3));
		opGauche.ajouteFils(new Nombre(2));
		opGauche.ajouteFils(new Nombre(6));
		opDroite.ajouteFils(new Nombre(8));
		opDroite.ajouteFils(new Nombre(7));
		racine.ajouteFils(opGauche);
		racine.ajouteFils(opDroite);
		System.out.println("Infixe : "+racine.notationInfix());
		System.out.println("Prefixe : "+racine.notationPrefix());
		System.out.println("Postfixe : "+racine.notationPostfix());
		System.out.println("Et le resultat est "+racine.evalue());
		
		
		System.out.println();
		System.out.println("Exemple 2 :");
		
		// Deuxieme exemple
		// on stocke l’expression (-(((5*3)/(2+6)) / (8-7)))
		Noeud racine2 = new OperateurMoins();
		Noeud principal = new OperateurDiv();
		Noeud opGauche2 = new OperateurDiv();
		Noeud opGaucheDroite2 = new OperateurPlus();
		Noeud opGaucheGauche2 = new OperateurMult();
		Noeud opDroite2 = new OperateurMoins();
		opGaucheGauche2.ajouteFils(new Nombre(5));
		opGaucheGauche2.ajouteFils(new Nombre(3));
		opGauche2.ajouteFils(opGaucheGauche2);
		opGauche2.ajouteFils(opGaucheDroite2);
		opGaucheDroite2.ajouteFils(new Nombre(2));
		opGaucheDroite2.ajouteFils(new Nombre(6));
		opDroite2.ajouteFils(new Nombre(8));
		opDroite2.ajouteFils(new Nombre(7));
		principal.ajouteFils(opGauche2);
		principal.ajouteFils(opDroite2);
		racine2.ajouteFils(principal);
		System.out.println("Infixe : "+racine2.notationInfix());
		System.out.println("Prefixe : "+racine2.notationPrefix());
		System.out.println("Postfixe : "+racine2.notationPostfix());
		System.out.println("Et le resultat est "+racine2.evalue());
		//Les exemples suivants sont decommenter pour tester les exceptions
		//pour tester TropDArgumentException
		principal.ajouteFils(new Nombre(10));
		// encore pour tester TropDArgumentException
		opDroite.ajouteFils(new Nombre(5));
		// pour tester UnsupportedOperationException
		Noeud unNombre = new Nombre(12);
		unNombre.ajouteFils(new Nombre(4));
	}

}