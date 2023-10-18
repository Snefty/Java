package tp5;

import java.util.List;

public class Fleuriste implements InterfaceFleuriste{
	
	private List<Fleur> stockFleur;
	private Bouquet bouquet;
	
	public Fleuriste(List<Fleur> stockFleur) {
		this.stockFleur = stockFleur;
		this.bouquet = null;
	}

	@Override
	public void creationBouquet(String name, String prenom) {
		this.bouquet = new Bouquet(name, prenom);
	}

	@Override
	public int quantiteEnStock(String nomFleur) {
		for(Fleur fleur : this.stockFleur) {
			if(fleur.getName().equals(nomFleur)) return fleur.getQuantité();
		}
		return 0;
	}

	@Override
	public float prixDUneFleur(String nomFleur) {
		for(Fleur fleur : this.stockFleur) {
			if(fleur.getName().equals(nomFleur)) return (float) fleur.getPrix();
		}
		return (float) 0.0;
	}
	
	
	/**
	 * Permet d'ajouter une fleur avec sa quantite dans le bouquet du client
	 */
	@Override
	public void ajoutFleur(String nomFleur, int qte) {
		//On prend les types de fleur dans notre stocke 
		for(Fleur fleur : this.stockFleur) {
			
			if(fleur.getName() == nomFleur) {
				//On verifie la quantité, si il reste assez on met ce que demande le client sinon on lui donne le reste du stock
				if(qte > fleur.getQuantité()) {
					bouquet.getCompo().add(new Fleur(nomFleur, fleur.getPrix(), fleur.getQuantité()));
					bouquet.setPrix(fleur.getPrix()*fleur.getQuantité());
					fleur.setPrix(0);
				}else {
					bouquet.getCompo().add(new Fleur(nomFleur, fleur.getPrix(), qte));
					bouquet.setPrix(fleur.getPrix()*qte);
					fleur.setPrix(fleur.getQuantité()-qte);
				}
			}
		}
	}
	
	/**
	 * Permet d'afficher la facture du bouquet
	 */
	@Override
	public void facturation() {
		
		/*
		 * Premier if (si le bouquet existe):
		 * 		- affiche la facture
		 * 
		 * Deuxieme if (si le bouquet n'existe pas):
		 * 		- Affiche un message
		 */
		if(bouquet != null) {
			System.out.println("\nFacture Bouquet :");
			System.out.println("Commander par " + bouquet.getNomClient() + " " + bouquet.getPrenomClient() + "\n");
			
			System.out.println("La composition comporte : ");
			bouquet.afficherCompo();
			
			System.out.println("\nPour un prix total de " + bouquet.getPrix() + "$\n");
		}else {
			System.out.println("\nAucun bouquet en cours de conception !!\n");
		}
		
	}
	
}
