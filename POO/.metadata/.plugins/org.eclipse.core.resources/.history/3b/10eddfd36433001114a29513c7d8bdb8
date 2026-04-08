package jeu;

import java.util.*;

import cartes.*;
import utils.GestionCartes;

public class Jeu {

	private Sabot sabot;

	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();

		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, jeu.donnerCartes());

		listeCartes = GestionCartes.melanger(listeCartes);

		Carte[] tab = listeCartes.toArray(new Carte[0]);

		sabot = new Sabot(tab);
	}

	public Sabot getSabot() {
		return sabot;
	}
}