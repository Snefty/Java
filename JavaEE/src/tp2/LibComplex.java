package tp2;

public class LibComplex {

	public double extraireImaginaire(Complexe e) {
		return e.getX();
	}

	public double moduleNombreComplex(Complexe e) {
		return Math.sqrt(Math.pow(e.getX(), 2) + Math.pow(e.getY(), 2));
	}

	public double argumentNombreComplex(Complexe e) {
		//return Math.tan( (e.getY() / e.getX()));
		return Math.cos(e.getY() / e.getX());
	}
	
	public Complexe sommeNombresComplex(Complexe e1, Complexe e2) {
		 return new Complexe((e1.getX()+e2.getX()), (e1.getY()+e2.getY()));
	}
	
	public Complexe multiplicationNombresComplex(Complexe e1, Complexe e2) {
		 return new Complexe((e1.getX()*e2.getX())-(e1.getY()*e2.getY())  , (e1.getX()*e2.getY())+(e1.getY()*e2.getY()) );
	}
	
}
