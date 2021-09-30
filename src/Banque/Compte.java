package Banque;

import java.util.ArrayList;


public abstract class Compte {

	private int idCompte = 0;
	private double solde;
	private String proprietaire;
	//List : interface (collection)
	//Arraylist : class
	private ArrayList<Banque.OperationsBancaire> listeOperations = new ArrayList<Banque.OperationsBancaire>();
	
	// Credite le compte d'une somme
	protected void Crediter(double somme, String desc) {

		makeCredit(this, somme, desc);
	}

	// Credite le compte d'une somme d'un compte
	protected void Crediter(Compte debiteur, double somme, String desc) {
		
		//On test si le compte debiteur à les fond nécessaires
		if (debiteur.testDecouvert(solde, somme)) {
			
			makeCredit(this, somme, desc);
			makeDebit(debiteur, somme, desc);
		} else {
			System.out.println("***Votre débiteur ne dispose pas des fonds nécessaires!***");
		}
	}

	// Débite le compte d'une somme
	protected void Debiter(double somme, String desc) {

		// Si le test est true, alors on execute la commande
		if (this.testDecouvert(this.solde, somme)) {
			
			makeDebit(this, somme, desc);
		} else {
			System.out.println("***Vous ne disposez pas des fonds nécessaires!***");
		}
	}

	// Débite le compte d'une somme pour créditer un autre compte
	protected void Debiter(Compte debiteur, double somme, String desc) {
		
		if (this.testDecouvert(this.solde, somme)) {

			makeCredit(debiteur, somme, desc);
			makeDebit(this, somme, desc);
		} else {
			System.out.println("***Vous ne disposez pas des fonds nécessaires!***");
		}
	}

	
	
	//ON test si on ne dépasse pas le découvert après opération
	public abstract boolean testDecouvert(double _solde, double _somme);

	//Fait l'opération de crédit et le note
	protected void makeCredit(Compte personne, double somme, String desc) {
		personne.solde += somme;
		OperationsBancaire temp = new OperationsBancaire(somme, SensOperation.Crédit, desc);
		personne.listeOperations.add(temp);
	}
	
	//Fait l'opération de débit et le note
	protected void makeDebit(Compte personne, double somme, String desc) {
		personne.solde -= somme;
		OperationsBancaire temp = new OperationsBancaire(somme, SensOperation.Débit, desc);
		personne.listeOperations.add(temp);
	}
	
	// Permet le résumer d'un compte générale
	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", proprietaire=" + proprietaire + ", operationBancaires="
				+ listeOperations + "]";
	}

	// Constructeur
	public Compte(double solde, String proprietaire) {
		super();
		this.solde = solde;
		this.proprietaire = proprietaire;
		this.idCompte = idCompte + 1;
	}

	// Getter Setter
	public ArrayList<OperationsBancaire> getOperationBancaires() {
		return listeOperations;
	}

	public double getSolde() {
		return solde;
	}

	public String getProprietaire() {
		return proprietaire;
	}
	
	public int getIdCompte() {
		return idCompte;
	}

	
	//Résumer du compte
	
	

	public void resumer() {
		String type = this.getClass().getSimpleName().equals("CompteCourant")?"Compte Courant":"Compte Epargne";
		System.out.println("************************************");
		System.out.println("Numeros de Compte: " + this.idCompte);
		System.out.println("Compte de: " + this.proprietaire + " de type " + type);
		System.out.println("Solde du compte: " + this.solde + "€");
		//System.out.println(this.listeOperations);
		for (OperationsBancaire operationsBancaire : listeOperations) {
			System.out.println(operationsBancaire.getDateOpe() + " : " + operationsBancaire.getSommeOpe() + " : " + operationsBancaire.getSensOpe());
		}
		System.out.println("************************************");
	}

}
