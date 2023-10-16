package tp5;

public interface InterfaceFleuriste {
	public void creationBouquet(String name, String prenom);
	public int quantiteEnStock(String nomFleur);
	public float prixDUneFleur(String nomFleur);
	public void ajoutFleur(String nomFleur, int qte);
	public void facturation();
}
