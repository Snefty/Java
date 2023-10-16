package expressionArithemitque;

public interface Noeud {
	
	public int evalue();
	public String notationPrefix();
	public String notationPostfix();
	public String notationInfix();
	public void ajouteFils(Noeud n);
}