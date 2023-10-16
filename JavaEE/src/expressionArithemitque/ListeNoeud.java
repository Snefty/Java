package expressionArithemitque;

import java.util.LinkedList;
import java.util.List;

public class ListeNoeud {
	
	List<Noeud> l;
	
	public ListeNoeud() {
		this.l = new LinkedList<Noeud>() ;
	}
	
	public int size()
	{
	return l.size();
	}
	
	public void put(Noeud n)
	{
	l.add(n);
	}
	
	public Noeud get(int indice)
	{
	return ((Noeud)(l.get(indice)));
	}

	
}