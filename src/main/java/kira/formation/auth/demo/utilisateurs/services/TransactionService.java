package kira.formation.auth.demo.utilisateurs.services;

import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;

/**
 * Service permettant les transaction entre les utilisateurs de cette API.
 * @author Killian
 *
 */
public interface TransactionService {

	/**
	 * L'utilisateur ajoute une somme d'argent a son solde.
	 * @param utilisateur qui recoit l'argent
	 * @param somme a ajouter au solde de l'utilisateur
	 */
	public void ajouterSolde(Utilisateur utilisateur, double somme);
	
	/**
	 * Le debiteur transfert une certaine somme d'argent au crediteur.
	 * @param debiteur utilisateur qui donne l'argent
	 * @param crediteur utilisateur qui recoit l'argent
	 * @param somme d'argent
	 */
	public void effectuerTransaction(Utilisateur debiteur, Utilisateur crediteur, double somme);
}
