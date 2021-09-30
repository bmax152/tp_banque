package Banque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCompte {

	public static void main(String[] args) {

		

//		System.out.println("Le compte courant de Nicolas a un d�couvert autoris� de 2000�");
//		CompteCourant compteNicoCourant = new CompteCourant(0d, "Nicolas", 2000d);
//		System.out.println("-->" + compteNicoCourant.toString());
//		listeCompte.add(compteNicoCourant);
//		
//		System.out.println("Le compte �pargne entreprise de Nicolas a un taux de 2%");
//		CompteEpargneEntreprise compteNicoEntreprise = new CompteEpargneEntreprise(0d, "Nicolas", 0.02);
//		System.out.println("-->" + compteNicoEntreprise.toString());
//		listeCompte.add(compteNicoEntreprise);
//		
//		System.out.println("Le compte courant de J�r�mie a un d�couvert autoris� de 500�");
//		CompteCourant compteJeremieCourant = new CompteCourant(0d, "J�r�mie", 500d);
//		System.out.println("-->" + compteJeremieCourant.toString());
//		listeCompte.add(compteJeremieCourant);
//		
//		System.out.println("Nicolas touche son salaire de 100�, pas cher pay� !");
//		compteNicoCourant.Crediter(100d, "Salaire");
//		System.out.println("-->" + compteNicoCourant.toString());
//
//		System.out.println("Il fait le plein de sa voiture : 50�");
//		compteNicoCourant.Debiter(50d, "Plein de la voiture");
//		System.out.println("-->" + compteNicoCourant.toString());
//
//		System.out.println("Il met de c�t� sur son compte �pargne entreprise la coquette somme de 20�");
//		compteNicoCourant.Debiter(compteNicoEntreprise, 20d, "Epargne");
//		System.out.println("-->" + compteNicoEntreprise.toString());
//
//		System.out.println(
//				"Puis il re�oit un cadeau de la banque de 100� car il a ouvert son compte pendant la p�riode promotionnelle");
//		compteNicoCourant.Crediter(100d, "Offre promo'");
//		System.out.println("-->" + compteNicoCourant.toString());
//
//		System.out
//				.println("Il remet ses 20� sur son compte bancaire car finalement, il ne se sent pas m�ga en s�curit�");
//		compteNicoEntreprise.Debiter(compteNicoCourant, 20d, "La s�curiter avant tout");
//		System.out.println("-->" + compteNicoCourant.toString());
//
//		System.out.println("J�r�mie ach�te un nouveau PC : 500�");
//		compteJeremieCourant.Debiter(500d, "Achat compulsif");
//		System.out.println("-->" + compteJeremieCourant.toString());
//
//		System.out.println("Puis il rembourse ses dettes � Nicolas : 200�");
//		compteJeremieCourant.Debiter(compteNicoCourant, 200d, "Remboursement");
//		System.out.println("-->" + compteJeremieCourant.toString());
//
//		System.out.println("-->Au final <--");
//		compteNicoCourant.resumer();
//		compteNicoEntreprise.resumer();
//		compteJeremieCourant.resumer();

		
		// TODO scanner en statique
		System.out.println("-------------------Test Avec Menu dynamique----------------------------");
		List<Banque.Compte> listeCompte = new ArrayList<Banque.Compte>();
		List<String> listeMenu = new ArrayList<String>();
		Compte compteActuelle = null; // Le compte sur lequel l'utilisateur est, aucun compte au d�but
		
		listeMenu.add("********** 1. Cr�ation Compte *********************************");
		listeMenu.add("********** 2. Consulter Compte (R�sum�) ***********************");
		listeMenu.add("********** 3. Op�ration de Cr�dit *****************************");
		listeMenu.add("********** 4. Op�ration de D�bit ******************************");
		listeMenu.add("********** 5. Banque : Liste Comptes **************************");
		listeMenu.add("********** 6. Quitter *****************************************");
		
		menuPrincipale(listeCompte, listeMenu, compteActuelle);

		
		System.out.println("-----------------------------------------------------------------------");
	}

	private static void menuPrincipale(List<Compte> listeCompte, List<String> listeMenu, Compte compteActuelle) {
		Scanner clavierScan = new Scanner(System.in);
		int choix;
		
		System.out.println("***************************************************************");
		System.out.println("********** Gestion Banque ==> Choisir Op�ration : *************");
		for (String menu : listeMenu) {
			System.out.println(menu);
		}
		System.out.println("***************************************************************");

		choix = clavierScan.nextInt();
		// choix = Integer.parseInt(clavier.nextLine()) /--> Permet de relancer un scanner, il lis la prochaine ligne!!
		switch (choix) {
		case 1:
			System.out.println("********** 1. Cr�ation Compte *********************************");
			menuCreation(listeCompte);
			compteActuelle = listeCompte.get(listeCompte.size() -1);
			menuPrincipale(listeCompte, listeMenu, compteActuelle);
			break;
		case 2:
			System.out.println("********** 2. Consulter Compte (R�sum�) ***********************");
			
			if (compteActuelle != null) {
				resumerCompte(compteActuelle);
			}else {
				System.out.println("*! Pas de compte en cour, retour au menu principale !*");
				menuPrincipale(listeCompte, listeMenu, compteActuelle);
			}
			break;
		case 3:
			System.out.println("********** 3. Op�ration de Cr�dit *****************************");
			if (compteActuelle != null) {
				crediterCompte(compteActuelle,clavierScan);
			}else {
				System.out.println("*! Pas de compte en cour, retour au menu principale !*");
				menuPrincipale(listeCompte, listeMenu, compteActuelle);
			}
			
			break;
		case 4:
			System.out.println("********** 4. Op�ration de D�bit ******************************");
			if (compteActuelle != null) {
				retirerCompte(compteActuelle,clavierScan);
			}else {
				System.out.println("*! Pas de compte en cour, retour au menu principale !*");
				menuPrincipale(listeCompte, listeMenu, compteActuelle);
			}
			
			break;
		case 5:
			System.out.println("********** 5. Banque : Liste Comptes **************************");
			if (compteActuelle != null) {
				afficherListeCompte(listeCompte);
			}else {
				System.out.println("*! Pas de compte enregistrer, retour au menu principale !*");
				menuPrincipale(listeCompte, listeMenu, compteActuelle);
			}
			break;
		case 6:
			System.out.println("********** 6. Quitter *****************************************");
			break;

		default:
			System.out.println("********** Une erreur est survenus *****************************************");
			menuPrincipale(listeCompte, listeMenu, compteActuelle);
			break;
		}
	}

	
	
	
	
	
	
	



	/*
	 * Cr�ation du compte
	 */
	private static void menuCreation(List<Compte> listeCompte) { // retourne un objet Compte quelque soit le choix
		Scanner clavierScan = new Scanner(System.in);
		int choix;
		System.out.println("Quel type de compte voulez vous ouvrir:");
		System.out.println("1: Compte Courant");
		System.out.println("2: Compte Epargne Entreprise");
		choix = clavierScan.nextInt();

		if (choix == 1) {
			listeCompte.add(creeCompteCourant(clavierScan)); // envois � la cr�ation d'un compte courant

		} else if (choix == 2) {
			listeCompte.add(creeCompteEntreprise(clavierScan)); // envois � la cr�ation d'un compte entreprise
		} else {
			System.out.println("Une erreur est survenue, veuillez recommencer");
			 menuCreation(listeCompte); // renvois le menu cr�ation si erreur
			
		}

	}

	/*
	 * Cr�ation d'un compte Entreprise
	 */
	private static CompteEpargneEntreprise creeCompteEntreprise(Scanner clavierScan) {
		double solde;
		double taux;
		String personne;
		System.out.println("Quel est votre nom?");
		personne = clavierScan.next();
		System.out.println("Quel est le solde de votre compte?");
		solde = clavierScan.nextDouble();
		System.out.println("Quel est votre taux?");
		taux = clavierScan.nextDouble();
		CompteEpargneEntreprise comptePersonne = new CompteEpargneEntreprise(solde, personne, taux);
		return comptePersonne;
	}

	/*
	 * Cr�ation d'un compte Courant
	 */
	private static CompteCourant creeCompteCourant(Scanner clavierScan) {
		double solde;
		double decouvert;
		String personne;
		System.out.println("Quel est votre nom?");
		personne = clavierScan.next();
		System.out.println("Quel est le solde de votre compte?");
		solde = clavierScan.nextDouble();
		System.out.println("Quel est votre d�couvert autoriser?");
		decouvert = clavierScan.nextDouble();
		CompteCourant comptePersonne = new CompteCourant(solde, personne, decouvert);
		return comptePersonne;
	}
	
	/*
	 * R�sumer de compte
	 */
	
	private static void resumerCompte(Compte compteActuelle) {

		compteActuelle.resumer();
	}
	
	
	/*
	 * Crediter son compte d'une somme
	 */
	private static void crediterCompte(Compte compteActuelle, Scanner clavierScan) {
		String desc;
		double somme;
		System.out.println("Entrer votre somme � cr�diter:");
		somme = clavierScan.nextDouble();
		System.out.println("Entrer une description:");
		desc = clavierScan.next();
		compteActuelle.Crediter(somme, desc);
		resumerCompte(compteActuelle);
	}
	
	
	/*
	 * Debiter son compte d'une somme
	 */
	private static void retirerCompte(Compte compteActuelle, Scanner clavierScan) {
		String desc;
		double somme;
		System.out.println("Entrer votre somme � retirer:");
		somme = clavierScan.nextDouble();
		System.out.println("Entrer une description:");
		desc = clavierScan.next();
		compteActuelle.Debiter(somme, desc);
		resumerCompte(compteActuelle);
	}
	
	
	/*
	 * Afficher liste des compte puis en choisir un
	 */

	private static void afficherListeCompte(List<Compte> listeCompte) {

		for (Compte compte : listeCompte) {
			
			System.out.println(compte.getIdCompte() + ": " + compte.getProprietaire() + ", solde actuelle: " + compte.getSolde());
		}
		
	}
	
	

//	/*
//	 * Le menu principale des fonctionalit�es
//	 */
//	private static void boucleMenu(ArrayList<Banque.Compte> listeCompte, Scanner clavierScan, Compte comptePersonne) {
//		int choix;
//		int boucle = 0;
//		do {
//			choix = menu(comptePersonne, clavierScan);
//
//			switch (choix) {
//			case 1:
//				comptePersonne.resumer();
//				break;
//			case 2:
//				crediterCompte(comptePersonne, clavierScan);
//				break;
//			case 3:
//				retirerCompte(comptePersonne, clavierScan);
//				break;
//			case 4:
//				System.out.println(listeCompte);
//				break;
//
//			default:
//				break;
//			}
//			System.out.println("Voulez-vous effectuer une autre op�rations?");
//			System.out.println("Tapez '1' pour continuer, '0' pour arr�ter");
//			boucle = clavierScan.nextInt();
//		} while (boucle == 1);
//	}
//
//	/*
//	 * Le corps du menu
//	 */
//	private static int menu(Compte comptePersonne, Scanner clavierScan) {
//		int choix;
//		System.out.println("Bienvenu Nicola");
//		System.out.println("R�capitulatif du compte: ");
//		comptePersonne.resumer();
//		System.out.println("Menu du compte: ");
//		System.out.println("1: R�sumer");
//		System.out.println("2: D�poser");
//		System.out.println("3: Retirer");
//		System.out.println("4: Afficher les compte de la banque");
//		System.out.println("Veuillez faire votre choix:");
//		choix = clavierScan.nextInt();
//		return choix;
//	}

	



}
