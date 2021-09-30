package Banque;

public class CompteEpargneEntreprise extends Compte {

	private double taux;

	@Override
	public String toString() {
		return "CompteEpargneEntreprise [proprietaire=" + getProprietaire() + ", solde=" + getSolde() + ", taux=" + taux
				+ ", operationBancaires=" + getOperationBancaires() + "]";
	}

	public CompteEpargneEntreprise(double solde, String proprietaire, double _taux) {
		super(solde, proprietaire);
		taux = _taux;
	}

	// Le CEE n'a pas de d�couvert, mais nous devons d�finir la m�thode, donc nous
	// renvoyons 'true' si superieur � 0
	@Override
	public boolean testDecouvert(double _solde, double _debit) {

		if (Math.abs(_solde) - _debit <= 0) {

			return true;
		} else {

			return false;
		}
	}

}
