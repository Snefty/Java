package tp4;

public class DemoConvoi {
	
	public static void main(String[] args) {
		
		Vehicle[] tabV1 = new Vehicle[4];
		
		CamionBache cb1 = new CamionBache("AT-452-FR", 3);
		CamionBache cb2 = new CamionBache("BF-453-FR", 25);
		PetitBus pb1 = new PetitBus("RT-642-GR", 45);
		CamionCiterne cc1 = new CamionCiterne("FT-785-LX", 4);
		
		System.out.println(cb1.calculerVitesse());
		System.out.println(cb2.calculerVitesse());
		System.out.println(pb1.calculerVitesse());
		System.out.println(cc1.calculerVitesse());
		System.out.println();
		
		tabV1[0] = cb1;
		tabV1[1] = cb2;
		tabV1[2] = pb1;
		tabV1[3] = cc1;
		
		Convoi c1 = new Convoi(tabV1);
		System.out.println(c1);
		
		System.out.println();
		System.out.println("La vitesse max par rapport au différents véhicles est : " + c1.vitesseMaxConvoi() + "km/h");
		
		System.out.println("La consommation des véhicule du convoi est : ");
		c1.consommationDuConvoieParvehicle();
	}
	
}
