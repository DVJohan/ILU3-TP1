package cartes;

public abstract class Limite extends Carte {

	// Classe interne pour le début de limite (50 km/h)
    public static class DebutLimite extends Limite {
        @Override
        public String toString() { return "Limite 50"; }
    }

    // Classe interne pour la fin de limite
    public static class FinLimite extends Limite {
        @Override
        public String toString() { return "Fin de Limite"; }
    }
	
	// Rien de plus dans le diagramme
}