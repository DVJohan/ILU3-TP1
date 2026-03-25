package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.print(jeu.affichageJeuDeCartes());
		
		System.out.println("CheckCount OK ? " + jeu.checkCount());
	}
}