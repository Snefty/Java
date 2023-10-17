package tp4;


public class Convoi {

	private Vehicle[] convoi;

	public Convoi(Vehicle[] convoi) {
		this.convoi = convoi;
	}

	public String toString() {
		String lr = "Le convoi comprend : \n";
		for(Vehicle o : convoi) {
			lr += o.toString() + "\n";
		}

		return lr;
	}

	public int vitesseMaxConvoi() {
		int minMax = convoi[0].calculerVitesse();

		for(int i = 0; i < convoi.length; i++) {
			if(convoi[i].calculerVitesse() < minMax) {
				minMax = convoi[i].calculerVitesse();
			}
		}

		return minMax;
	}
	
	public void consommationDuConvoieParvehicle(){
		for(Vehicle v : convoi) {
			System.out.println(v.consommation(vitesseMaxConvoi()) + "l");
		}
	}

}
