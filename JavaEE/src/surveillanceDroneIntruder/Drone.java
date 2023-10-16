package surveillanceDroneIntruder;

public class Drone extends Bot{

	private boolean attraperIntruder;
	
	public Drone(int posX, int posY) {
		super(posX, posY, Entity.Drone);
	}

	public boolean isAttraperIntruder() {
		return attraperIntruder;
	}

	public void setAttraperIntruder(boolean attraperIntruder) {
		this.attraperIntruder = attraperIntruder;
	}
	
}