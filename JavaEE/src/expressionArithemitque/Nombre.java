package expressionArithemitque;

public class Nombre implements Noeud {

	private int nbr;

	public Nombre(int nbr) {
		this.nbr = nbr;
	}
	
	@Override
	public int evalue() {
		return nbr;
	}

	@Override
	public String notationPrefix() {
		return " " + nbr;
	}

	@Override
	public String notationPostfix() {
		return nbr + " ";
	}

	@Override
	public String notationInfix() {
		return " " + nbr + " ";
	}

	@Override
	public void ajouteFils(Noeud n){
		new UnsupportedOperationExcveption();
	}

}
