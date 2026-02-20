package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

	private final Carte[] cartes;
	private int nbCartes;          // nombre effectif
	private int modCount = 0;      // pour ConcurrentModification

	public Sabot(Carte[] cartes) {
		this.cartes = new Carte[cartes.length];
		System.arraycopy(cartes, 0, this.cartes, 0, cartes.length);
		this.nbCartes = cartes.length;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
			throw new IllegalStateException("Sabot plein (dépassement de capacité)");
		}
		cartes[nbCartes++] = carte;
		modCount++;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterator<>() {
			private int expectedModCount = modCount;
			private int cursor = 0;
			private boolean canRemove = false;

			private void checkComodif() {
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
			}

			@Override
			public boolean hasNext() {
				checkComodif();
				return cursor < nbCartes;
			}

			@Override
			public Carte next() {
				checkComodif();
				if (!hasNext()) throw new NoSuchElementException();
				canRemove = true;
				return cartes[cursor++];
			}

			@Override
			public void remove() {
				checkComodif();
				if (!canRemove) throw new IllegalStateException("remove() illégal (next() manquant ou déjà remove)");
				// on supprime l’élément à cursor-1
				int idx = cursor - 1;
				for (int i = idx; i < nbCartes - 1; i++) {
					cartes[i] = cartes[i + 1];
				}
				cartes[nbCartes - 1] = null;
				nbCartes--;
				cursor--; // reculer car on a décalé
				canRemove = false;

				modCount++;
				expectedModCount++;
			}
		};
	}

	// "piocher" doit renvoyer et supprimer la première carte via un itérateur (page 6) :contentReference[oaicite:2]{index=2}
	public Carte piocher() {
		Iterator<Carte> it = iterator();
		if (!it.hasNext()) {
			throw new NoSuchElementException("Sabot vide");
		}
		Carte c = it.next();
		it.remove();
		return c;
	}
}