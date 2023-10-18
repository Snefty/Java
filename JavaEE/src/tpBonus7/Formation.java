package tpBonus7;

import java.util.ArrayList;
import java.util.List;

public class Formation {
	
	private String id;
	private List<Matiere> listMatiére;
	
	public Formation(String id) {
		this.id = id;
		this.listMatiére = new ArrayList<Matiere>();
	}
	
	public boolean ajouterMatiere(Matiere mat) {
		return listMatiére.add(mat);
	}
	
	public boolean supprimerMatiere(Matiere mat) {
		return listMatiére.remove(mat);
	}
	
	public int coeffDeLaMatiere(Matiere mat) {
		return mat.getCoeff();
	}

	public List<Matiere> getListMatiére() {
		return listMatiére;
	}
	
	public String toString() {
		String a = "La formation " + this.id + " : \n";
		
			for(Matiere mat : this.listMatiére) {
				a+= " -> " + mat + "\n";
			}
			
			return a;
	}

	public String getId() {
		return id;
	}
	
}
