package surveillanceDroneIntruder;

public class Bot {
	
	private int posX;
	private int posY;
	private Entity genre;
	private boolean estTourPassé;
	private boolean surStockArgent;
	
	public Bot(int posX, int posY, Entity genre) {
		this.posX = posX;
		this.posY = posY;
		this.genre = genre;
		this.estTourPassé = false;
		this.surStockArgent = false;
	}

	public boolean isSurStockArgent() {
		return surStockArgent;
	}

	public void setSurStockArgent(boolean surStockArgent) {
		this.surStockArgent = surStockArgent;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void modifierPos(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public boolean isEstTourPassé() {
		return estTourPassé;
	}

	public void setEstTourPassé(boolean estTourPassé) {
		this.estTourPassé = estTourPassé;
	}

	public Entity getGenre() {
		return genre;
	}
}