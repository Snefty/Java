package tp1;

public class Rectangle {

	private Point origine;
	private int hauteur = 0;
	private int largeur = 0;

	public Rectangle(Point p, int l, int h) {
		this.hauteur = h;
		this.largeur = l;
		this.origine = p;
	}
	
	public int perimetre() {
		return (this.largeur+hauteur)*2 ;
	}
	
	public int surface() {
		return this.largeur*hauteur ;
	}
	
	public Point getOrigine() {
		return origine;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int abscisseOrigin() {
		return origine.x;
	}

	public int ordonnéOrigin() {
		return origine.y;
	}
}
