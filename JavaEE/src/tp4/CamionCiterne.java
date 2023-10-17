package tp4;

public class CamionCiterne extends Vehicle{

	private final int CHARGEMAX = 10;
	
	public CamionCiterne(String immatriculation, int chargeVehicle) {
		super(immatriculation, 3, chargeVehicle);
	}
	
	public String toString() {
		return " -> Camion citerne " + super.toString() + " " +  this.CHARGEMAX + " " + super.chargeVehicle;
	}
	
	public int calculerVitesse() {
		if(chargeVehicle > CHARGEMAX) return 80-20;
		if(chargeVehicle < 0) return 130;
		if(chargeVehicle < 1) return 110;
		if(chargeVehicle > 1 && chargeVehicle < 4) return 90;
		return 80;
	}
}
