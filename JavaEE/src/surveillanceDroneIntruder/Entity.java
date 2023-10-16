package surveillanceDroneIntruder;

public enum Entity {

	Drone('D'),
	Intruder('I'),
	Barrière('#'),
	Source_D_Argent('$'),
	Case_Vide('_');
	
	char symbole;
	private Entity(char symbole) {
		this.symbole = symbole;
	}
	
	public char getSymbole() {
		return symbole;
	}
}
