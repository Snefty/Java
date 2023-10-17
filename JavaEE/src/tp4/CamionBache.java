package tp4;

public class CamionBache extends Vehicle{
	
	private final int CHARGEMAX = 20;
	
	public CamionBache(String immatriculation,int chargeVehicle) {
		super(immatriculation, 4, chargeVehicle);
	}
	
	public String toString() {
		return " -> Camion bache " + super.toString() + " " +  this.CHARGEMAX + " " + super.chargeVehicle;
	}
	
	public int calculerVitesse() {
		if(chargeVehicle > CHARGEMAX) return 80-20;
		if(chargeVehicle < 0) return 130;
		if(chargeVehicle <= 3) return 110;
		if(chargeVehicle > 3 && chargeVehicle <= 7) return 90;
		return 80;
	}
}
