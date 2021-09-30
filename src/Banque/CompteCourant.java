package Banque;

public class CompteCourant extends Compte {


	private final double decouvert;
	
	//On test les valeur en positif pour vérifier que l'on ne dépasse pas le découvert
	public boolean testDecouvert(double _solde, double _somme) {
		
		if(Math.abs(_solde) + _somme <= decouvert) {
			
			return true;
		}else {
			
			return false;
		}
	}
	
	
	//toString
	@Override
	public String toString() {
		return "CompteCourant [proprietaire=" + getProprietaire() + ", solde=" + getSolde() + ", decouvert=" + decouvert
				+ "]\n Historique :  " + getOperationBancaires();
	}

	//Constructeur
	public CompteCourant(double solde, String proprietaire, double _decouvert) {
		super(solde, proprietaire);
		decouvert = _decouvert;
	}

	//Getter
	public double getDecouvert() {
		return decouvert;
	}

	

}
