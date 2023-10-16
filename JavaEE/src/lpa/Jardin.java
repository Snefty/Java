package lpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jardin {
	
	private String adresse;
	private List<Enfant> lesEnfants;
	
	public Jardin(String adresse) {
		this.adresse = adresse;
		this.lesEnfants = new ArrayList<Enfant>();
	}
	
	public Iterator<Enfant> getLesEnfantsIterator() {
		return lesEnfants.iterator();
	}
	
	public String getAdresse() { return this.adresse;}
	
	public boolean ajouteEnfant (Enfant e) {
		return lesEnfants.add(e);
	}
	
}