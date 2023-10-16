package tp7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

	private String speudo;
	private List<Carte> deckCartePrincipal;
	private List<Carte> deckCartesGagner;

	public Player(String name) {
		this.speudo= name;
		this.deckCartePrincipal = new ArrayList<Carte>();
		this.deckCartesGagner = new ArrayList<Carte>();
	}

	public List<Carte> getCartesGagner() {
		return deckCartesGagner;
	}

	public String getSpeudo() {
		return speudo;
	}

	public void setSpeudo(String speudo) {
		this.speudo = speudo;
	}

	public List<Carte> getCartes() {
		return deckCartePrincipal;
	}

	public void ajouterCarte(Carte o) {
		deckCartePrincipal.add(o);
	}

	public void ajouterCarteGagner(Carte o) {
		deckCartesGagner.add(o);
	}

	public Carte tirerCarte() {
		if(!this.deckCartePrincipal.isEmpty()) {
			return this.deckCartePrincipal.removeLast();
		}else {
			if(!this.deckCartesGagner.isEmpty()) {
				this.deckCartePrincipal.addAll(deckCartesGagner);
				Collections.shuffle(deckCartePrincipal);
				this.deckCartesGagner.clear();
				return this.deckCartePrincipal.removeLast();
			}else {
				return null;
			}
		}
	}
	
	public boolean isPlayerPlusDeCarte() {
		return this.deckCartePrincipal.isEmpty() && this.deckCartesGagner.isEmpty();
	}
	
	public String toString() {
		System.out.println("Le jeu de " + speudo + " : ");
		for(Carte carte : this.deckCartePrincipal) {
			System.out.println(carte);
		}
		return "";
	}
}
