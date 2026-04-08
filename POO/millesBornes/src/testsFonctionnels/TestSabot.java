package testsFonctionnels;

import java.util.Iterator;



import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	public static void main(String[] args) {
		Carte[] cartes = new JeuDeCartes().donnerCartes();
		Sabot sabot = new Sabot(cartes);

		// a) piocher jusqu’à vide
		while (!sabot.estVide()) {
			System.out.println("je pioche " + sabot.piocher());
		}

		// b) refaire avec itérateur + remove
		sabot = new Sabot(cartes);
		Iterator<Carte> it = sabot.iterator();
		while (it.hasNext()) {
			System.out.println("je pioche " + it.next());
			it.remove();
		}

		// c) modification concurrente : appeler piocher dans la boucle -> exception
		sabot = new Sabot(cartes);
		try {
			Iterator<Carte> it2 = sabot.iterator();
			while (it2.hasNext()) {
				it2.next();
				sabot.piocher(); // doit lever ConcurrentModificationException
			}
		} catch (Exception e) {
			System.out.println("Exception attendue: " + e);
		}

		// Autre cas demandé : piocher avant puis ajouter dans la boucle -> exception
		sabot = new Sabot(cartes);
		sabot.piocher(); // pour éviter débordement tableau si tu veux ajouter après
		try {
			Iterator<Carte> it3 = sabot.iterator();
			while (it3.hasNext()) {
				it3.next();
				sabot.ajouterCarte(new Botte(Type.ACCIDENT)); // As du volant
			}
		} catch (Exception e) {
			System.out.println("Exception attendue: " + e);
		}
	}
}