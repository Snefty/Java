package tp4;

public class PetitBus extends Vehicle{
	
	public PetitBus(String immatriculation, int chargeVehicle) {
		super(immatriculation, 4, chargeVehicle);
	}
	
	public String toString() {
		return " -> petit bus " + super.toString() + " " + super.chargeVehicle;
	}
	
	public int calculerVitesse() {
		return 150;
	}
}
