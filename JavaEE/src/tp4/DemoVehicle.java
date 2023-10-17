package tp4;

public class DemoVehicle {
	
	public static void main(String[] args) {
		CamionBache cb1 = new CamionBache("AT-452-FR", 2);
		CamionBache cb2 = new CamionBache("BF-453-FR", 35);
		
		System.out.println(cb1);
		System.out.println(" vitesse de -> " + cb1.calculerVitesse());
		System.out.println(cb2);
		System.out.println(" vitesse de -> " + cb2.calculerVitesse());
	}
	
}
