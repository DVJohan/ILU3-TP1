package utils;

import java.util.*;


public class GestionCartes {
	//a
	//Version 1 simple
	public static <T> T extraire(List<T> liste) {
		Random r = new Random();
		int index = r.nextInt(liste.size());
		return liste.remove(index);
	}
	
	
	//Version avec Literator
	public static <T> T extraireV2(List<T> liste) {
		Random r = new Random();
		int index = r.nextInt(liste.size());

		ListIterator<T> it = liste.listIterator();
		int i = 0;

		while (it.hasNext()) {
			T val = it.next();
			if (i == index) {
				it.remove();
				return val;
			}
			i++;
		}
		return null;
	}
	
	
	//b
	public static <T> List<T> melanger(List<T> liste) {
		List<T> melange = new ArrayList<>();

		while (!liste.isEmpty()) {
			melange.add(extraire(liste));
		}
		return melange;
	}
	
	
	//c
	public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
		if (l1.size() != l2.size()) return false;

		for (T e : l1) {
			if (Collections.frequency(l1, e) != Collections.frequency(l2, e)) {
				return false;
			}
		}
		for (T e : l2) {
			if (Collections.frequency(l2, e) != Collections.frequency(l1, e)) {
				return false;
			}
		}
		return true;
	}
	
	
	//d

	public static <T> List<T> rassembler(List<T> liste) {
		List<T> res = new ArrayList<>();

		while (!liste.isEmpty()) {
			T ref = liste.get(0);
			Iterator<T> it = liste.iterator();

			while (it.hasNext()) {
				T val = it.next();
				if (val.equals(ref)) {
					res.add(val);
					it.remove();
				}
			}
		}
		return res;
	}
	
	
	
	//e
	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> it1 = liste.listIterator();

		while (it1.hasNext()) {
			T courant = it1.next();

			ListIterator<T> it2 = liste.listIterator(it1.nextIndex());

			while (it2.hasNext()) {
				T val = it2.next();

				if (val.equals(courant)) {
					return false; // trouvé plus loin → pas regroupé
				}
			}
		}
		return true;
	}

}
