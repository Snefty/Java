package tp4;

public class HabitationIndividuelle extends Habitation{

	private int nbPiece;
	private boolean piscine;

	public HabitationIndividuelle(String proprietaire, String adresse, double surface, int nbPiece, boolean piscine) {
		super(proprietaire, adresse, surface);
		this.nbPiece = nbPiece;
		this.piscine = piscine;
	}

	public void affiche() {
		super.affiche();
		System.out.print(" " + this.nbPiece + " " + this.piscine);
	}

	public double impot() {
		double impot = super.impot();
		if(nbPiece < 1) impot += 100;
		else impot += 100*nbPiece;
		if(piscine) impot += 500;

		return impot;
	}
	
}
