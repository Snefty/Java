package tpBonus5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Genealogie {

	private Map<Personne, Personne> peres;
	private Map<Personne, Personne> meres;

	public Genealogie(Map<Personne, Personne> peres,Map<Personne, Personne> meres) {
		this.meres = meres;
		this.peres = peres;
	}

	public List<Personne> fils(Personne e){
		List<Personne> fils = new ArrayList<>();

		for(Map.Entry<Personne, Personne> entry : peres.entrySet()) {
			if(entry.getValue().equals(e)) fils.add(entry.getKey());
		}

		for(Map.Entry<Personne, Personne> entry : meres.entrySet()) {
			if(entry.getValue().equals(e)) fils.add(entry.getKey());
		}

		return fils;
	}

	public List<Personne> aieux(Personne e){
		List<Personne> lesVieux = new ArrayList<>();

		for(Map.Entry<Personne, Personne> entry : peres.entrySet()) {
			if(entry.getKey().equals(e)) { 
				lesVieux.add(entry.getValue());
				lesVieux.addAll(aieux(entry.getValue()));
			}
		}

		for(Map.Entry<Personne, Personne> entry : meres.entrySet()) {
			if(entry.getKey().equals(e)) { 
				lesVieux.add(entry.getValue());
				lesVieux.addAll(aieux(entry.getValue()));
			}
		}

		return lesVieux;
	}

	public boolean isAieuxCommun(Personne a1, Personne a2) {
		for(Personne other : aieux(a1)) {
			if(aieux(a2).contains(other)) return true;
		}
		return false;
	}
	
	public List<Personne> isMotherQueDesFille(){
		List<Personne> motherQueFille = new ArrayList<>();
		boolean isPasGarçon = true;
	
		for(Map.Entry<Personne, Personne> entry : meres.entrySet()) {
			
			for(Personne e : fils(entry.getValue())) {
				if(e.getGenre() == Genre.HOMME) isPasGarçon = false;
			}
			
			if(isPasGarçon) motherQueFille.add(entry.getValue());
			else isPasGarçon = true;
		}
		
		return motherQueFille;
	}
	
}
