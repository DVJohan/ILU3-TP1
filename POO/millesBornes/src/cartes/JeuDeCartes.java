package cartes;

import java.util.*;

public class JeuDeCartes {

	// 19 types de cartes dans la config (page 5) :contentReference[oaicite:1]{index=1}
	private final Configuration[] typesDeCartes = new Configuration[] {
		new Configuration(new Borne(25), 10),
		new Configuration(new Borne(50), 10),
		new Configuration(new Borne(75), 10),
		new Configuration(new Borne(100), 12),
		new Configuration(new Borne(200), 4),

		new Configuration(new Parade(Type.FEU), 14),        // Feu Vert
		new Configuration(new FinLimite(), 6),              // Fin Limite
		new Configuration(new Parade(Type.ESSENCE), 6),     // Bidon d'essence
		new Configuration(new Parade(Type.CREVAISON), 6),   // Roue de secours
		new Configuration(new Parade(Type.ACCIDENT), 6),    // Réparation

		new Configuration(new Attaque(Type.FEU), 5),        // Feu Rouge
		new Configuration(new DebutLimite(), 4),            // Limite 50
		new Configuration(new Attaque(Type.ESSENCE), 3),    // Panne d'essence
		new Configuration(new Attaque(Type.CREVAISON), 3),  // Crevaison
		new Configuration(new Attaque(Type.ACCIDENT), 3),   // Accident

		new Configuration(new Botte(Type.FEU), 1),          // Prioritaire
		new Configuration(new Botte(Type.ESSENCE), 1),      // Citerne
		new Configuration(new Botte(Type.CREVAISON), 1),    // Increvable
		new Configuration(new Botte(Type.ACCIDENT), 1)      // As du volant
	};

	public String affichageJeuDeCartes() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("JEU :\n");
		for (Configuration c : typesDeCartes) {
			sb.append(c.getNbExemplaires()).append(" ").append(c.getCarte()).append("\n");
		}
		return sb.toString();
	}

	public Carte[] donnerCartes() {
		int total = 0;
		for (Configuration c : typesDeCartes) total += c.getNbExemplaires();

		Carte[] res = new Carte[total];
		int k = 0;
		for (Configuration c : typesDeCartes) {
			for (int i = 0; i < c.getNbExemplaires(); i++) {
				res[k++] = c.getCarte();
			}
		}
		return res;
	}
	
	
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		List<Carte> liste = Arrays.asList(cartes);

		for (Configuration c : typesDeCartes) {
			int attendu = c.getNbExemplaires();
			int reel = Collections.frequency(liste, c.getCarte());

			if (attendu != reel) {
				return false;
			}
		}
		return true;
	}

}