package tp1;

/**
 * Classe de test
 * 
 * @author 59013-15-06
 * @version 1.0
 */
public class DemoVelo {

	/**
	 * Fonction principale recupérant des arguments en parametre
	 * @param args
	 */
	public static void main(String[] args) {
		Velo v1 = new Velo();
		//Velo v2 = new Velo();

		/*
		v1.accelerer(10);
		v1.imprimeEtat();
		v2.accelerer(20);
		v2.imprimeEtat();
		 */
		
		System.out.println("Accelerer");
		while(v1.getVitesse() < 40) {
			v1.accelerer(3);
			v1.imprimeEtat();
		}
		
		System.out.println();
		
		int i = 0;
		
		System.out.println("Freiner");
		while(i < 20 && v1.getVitesse() > 0) {
			v1.freiner(5);
			if(v1.getVitesse() < 0) System.out.println("vitesse : " + 0);
			else v1.imprimeEtat();
			i++;
		}

	}
}
