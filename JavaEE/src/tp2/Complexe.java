package tp2;

public class Complexe {
	
	private double x;
	private double y;
	
	public Complexe(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Complexe() {
		this(0,0);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public String toString() {
		return "Forme algébrique : " + getX()+ "+" + getY()+ "i";
	}
	
}
