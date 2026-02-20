package cartes;

public class Botte extends Probleme {
	
	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		
		String s = getType().libelleBotte();
		
		if (s == null) {
			return "Botte(" + getType() + ")"; // sécurité si type sans botte
		}
		
		return s;
	}
}