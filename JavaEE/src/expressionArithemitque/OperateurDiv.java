package expressionArithemitque;

public class OperateurDiv implements Noeud {

	private ListeNoeud noeud;
	
	public OperateurDiv() {
		this.noeud = new ListeNoeud();
	}
	
	@Override
	public int evalue() {
		int i = 0;

		i = this.noeud.get(0).evalue() / this.noeud.get(1).evalue();
		
		System.out.println("/ " + i);
		
		return i;
	}

	@Override
	public String notationPrefix() {
		String l = "(/";

		for(int idx=0; idx<this.noeud.size() ;idx++) {
			l += this.noeud.get(idx).notationPrefix();
		}
		
		l += " )";
		return l;
	}

	@Override
	public String notationPostfix() {
		String l = "( ";

		for(int idx=0; idx<this.noeud.size() ;idx++) {
			l += this.noeud.get(idx).notationPostfix();
		}

		l += "/)";
		
		return l;
	}

	@Override
	public String notationInfix() {
		String l = "(";

		for(int idx=0; idx<this.noeud.size() ;idx++) {
			l += this.noeud.get(idx).notationInfix();
			if(idx+1 < this.noeud.size()) {
				l += "/";
			}
		}
		
		l += ")";
		
		return l;
	}

	@Override
	public void ajouteFils(Noeud n) {
		if(this.noeud.size() < 2) {
			this.noeud.put(n);
		}else {
			new TropDArgumentException();
		}
	}

}
