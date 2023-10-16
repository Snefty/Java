package tp7;

public enum Rang {
	
	DEUX("Deux", 1),
	TROIS("Trois",2),
	QUATRE("Quatre",3),
	CINQ("Cinq",4),
	SIX("Six",5),
	SEPT("Sept",6),
	HUIT("Huit",7),
	NEUF("Neuf",8),
	DIX("Dix",9),
	VALET("Valet",10),
	DAME("Dame",11),
	ROI("Roi",12),
	AS("As",13);
	
	private String type;
	private int nbforce;
	private Rang(String type, int nbforce) {
		this.type = type;
		this.nbforce = nbforce;
	}
	
	public String getType() {
		return type;
	}

	public int getNbforce() {
		return nbforce;
	}
	
}
