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

	// Le CEE n'a pas de découvert, mais nous devons définir la méthode, donc nous
	// renvoyons 'true' si superieur à 0
	@Override
	public boolean testDecouvert(double _solde, double _debit) {

		if (Math.abs(_solde) - _debit <= 0) {

			return true;
		} else {

			return false;
		}
	}

}
