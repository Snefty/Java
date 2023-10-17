package tp4;

public class HabitationProfessionnelle extends Habitation{

	private int nbEmployes;

	public HabitationProfessionnelle(String proprietaire, String adresse, double surface, int nbEmploye) {
		super(proprietaire, adresse, surface);
		this.nbEmployes = nbEmploye;
	}

	public void affiche() {
		super.affiche();
		System.out.print(" " + this.nbEmployes);
	}

	public double impot() {
		double impot = super.impot();
		int tmp = nbEmployes;
		
		while(tmp > 10) {
			impot += 1000;
			tmp = tmp - 10;
		}

		return impot;
	}

}
