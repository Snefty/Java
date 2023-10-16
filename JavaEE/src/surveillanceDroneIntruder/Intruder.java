package surveillanceDroneIntruder;

public class Intruder extends Bot{
	
	private final static int MAX_SOURCE_ARGENT = 2;
	private int nbrSourceArgent;
	private boolean attraperSourceArgent;
	
	public Intruder(int posX, int posY) {
		super(posX, posY, Entity.Intruder);
		this.nbrSourceArgent = 0;
		this.attraperSourceArgent = false;
	}

	public int getNbrSourceArgent() {
		return nbrSourceArgent;
	}

	public void setNbrSourceArgent(int nbrSourceArgent) {
		this.nbrSourceArgent += nbrSourceArgent;
	}

	public boolean isAttraperSourceArgent() {
		return attraperSourceArgent;
	}

	public void setAttraperSourceArgent(boolean attraperSourceArgent) {
		this.attraperSourceArgent = attraperSourceArgent;
	}

	public boolean possibleRecup() {
		return nbrSourceArgent == MAX_SOURCE_ARGENT;
	}
	
}