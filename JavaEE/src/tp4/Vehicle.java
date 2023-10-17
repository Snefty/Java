package tp4;

public class Vehicle {
	
	private String immatriculation;
	private int poidAVide;
	protected int chargeVehicle;
	
	public Vehicle(String immatriculation, int poidAVide, int chargeVehicle) {
		this.immatriculation = immatriculation;
		this.poidAVide = poidAVide;
		this.chargeVehicle = chargeVehicle;
	}
	
	public String toString() {
		return this.immatriculation + " " + this.poidAVide;
	}
	
	public int calculerVitesse() {
		return 0;
	}
	
	public int poidTotal() {
		return poidAVide + chargeVehicle;
	}
	
	public float consommation (int vitesse) {
		return Utilitaires.consommation(vitesse, poidTotal());
	}
}
