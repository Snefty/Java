package lpa;

import java.util.Iterator;
import java.util.List;

public class LPA {
	
	private List<Chocolat> lesChocolats;
	private List<Jardin> LesJardin;
	private Jardin monJardin;
	private Iterator<Jardin> iterjardins;
	
	 public LPA(List<Chocolat> lesChocolats, List<Jardin> lesJardin) {
		 this.lesChocolats = lesChocolats;
		 this.LesJardin = lesJardin;
		 this.iterjardins = lesJardin.iterator();
		 avancer();
	 }
	 
	 public void déposerChocolatEnfant(Enfant e) {
		 for(Chocolat i : lesChocolats) {
			 if(i.convient(e)) {
				 e.mangeChocolat(i);
				 lesChocolats.remove(i);
			 }
		 }
	 }
	 
	 public void déposerChocolatJardin() {
		 Enfant enfant = null;
		 while(!this.monJardin.getLesEnfantsIterator().hasNext()) {
			 if(!lesChocolats.isEmpty()) {
				 enfant = this.monJardin.getLesEnfantsIterator().next();
				 déposerChocolatEnfant(enfant);
				 this.monJardin.getLesEnfantsIterator().remove();
			 }
		 }
		 
	 }
	 
	 public boolean avancer() {
		 
		 if(LesJardin.isEmpty() && lesChocolats.isEmpty()) {
			 return false;
		 }
		 monJardin = iterjardins.next();
		 iterjardins.remove();
		 return true;
	 }
}