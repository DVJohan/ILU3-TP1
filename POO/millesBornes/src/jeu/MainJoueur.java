package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import cartes.Carte;

public class MainJoueur implements Iterable<Carte> {
    private List<Carte> cartesEnMain = new ArrayList<>();

    public void prendre(Carte c) {
        cartesEnMain.add(c); // [cite: 18]
    }

    public void jouer(Carte c) {
        assert cartesEnMain.contains(c); // [cite: 18]
        cartesEnMain.remove(c);
    }

    @Override
    public String toString() {
        return cartesEnMain.toString(); // [cite: 19]
    }

    @Override
    public Iterator<Carte> iterator() {
        return cartesEnMain.iterator(); // [cite: 20]
    }
}