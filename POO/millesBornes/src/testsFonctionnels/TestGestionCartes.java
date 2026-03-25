/*package testsFonctionnels;

import java.util.*;

import cartes.*;
import utils.GestionCartes;

public class TestGestionCartes {

	public static void main(String[] args) {

		JeuDeCartes jeu = new JeuDeCartes();

		// Liste non mélangée
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}

		// Copie pour travailler
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

		System.out.println("Liste initiale :");
		System.out.println(listeCartes);

		// Mélange
		listeCartes = GestionCartes.melanger(listeCartes);

		System.out.println("\nListe mélangée :");
		System.out.println(listeCartes);

		System.out.println("\nMélange correct ? " +
			GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

		// Rassemblement
		listeCartes = GestionCartes.rassembler(listeCartes);

		System.out.println("\nListe rassemblée :");
		System.out.println(listeCartes);

		System.out.println("\nRassemblement correct ? " +
			GestionCartes.verifierRassemblement(listeCartes));
	}
}*/

package testsFonctionnels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {
	public static void main(String args[]) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println(
				"liste m�lang�e sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassembl�e sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));

	}

}