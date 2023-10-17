package tpBonus_5;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CD {
	
	private String code, titre, style, artiste;
	private Date retour;
	private Membre emprunteur;
	
	public CD(String code, String titre,String style, String artiste) {
		this.code = code;
		this.artiste = artiste;
		this.style = style;
		this.titre = titre;
		this.retour = new Date();
		this.emprunteur = null;
	}
	
	public boolean estEmprunte() {
		return emprunteur != null; 
	}
	
	public void emprunter(Membre membre) {
		this.emprunteur = membre;
		membre.augmenterNbrEmprunt();
		this.retour = Date.from(Instant.now().plus(6,ChronoUnit.DAYS)) ;
	}
	
	public void rendre() {
		emprunteur = null;
		retour = null;
	}
	
	public boolean doitEtreRendu() {
		return Date.from(Instant.now()).compareTo(retour) > 0;
	}

	public Membre getEmprunteur() {
		return emprunteur;
	}

	public String getArtiste() {
		return artiste;
	}

	public String getTitre() {
		return titre;
	}
	
	public String toString() {
		return "[" + this.code + "] -> " + this.artiste + " : " + this.titre + " (" + this.style + ")";
	}
}
