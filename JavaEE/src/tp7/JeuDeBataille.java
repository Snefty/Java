package tp7;

public class JeuDeBataille {
	
	public static void main(String[] args) {
		Paquet paquetDeCarte = new Paquet();
		
		String namePlayer1 = "Toto";
		String namePlayer2 = "theMotherOfToto";
		
		paquetDeCarte.game(namePlayer1,namePlayer2);
	}	
}
