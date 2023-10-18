package tpBonus7;

public enum Matiere {

	MATH("Math",3),
	HISTOIRE_GEOGRAPHIE("Histoire-Geographie",2),
	ANGLAIS("Anglais",2),
	SCPECIALITE("Specialite",8),
	FRANCAIS("Français",2),
	PHILO("Philo",1);

	private int coeff;
	private String nomMat;
	private Matiere(String nomMat, int coeff) {
		this.nomMat = nomMat;
		this.coeff = coeff;
	}
	
	public String getNomMat() {
		return nomMat;
	}


	public int getCoeff() {
		return coeff;
	}
}
