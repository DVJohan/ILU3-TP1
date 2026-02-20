package cartes;

public enum Type {
	
	
	FEU("Feu Rouge", "Feu Vert", "Prioritaire"),
	ESSENCE("Panne d'essence", "Bidon d'essence", "Citerne"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ACCIDENT("Accident", "Réparation", "As du volant"),
	LIMITATION("Limite 50", "Fin Limite", null); // botte inexistante ici

	private final String attaque;
	private final String parade;
	private final String botte;

	Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String libelleAttaque(){ 
		return attaque; 
		}
	
	public String libelleParade(){ 
		return parade; 
		}
	
	public String libelleBotte(){ 
		return botte; 
		}

}
