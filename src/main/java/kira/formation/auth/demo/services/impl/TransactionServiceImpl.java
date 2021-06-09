package kira.formation.auth.demo.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import kira.formation.auth.demo.models.Utilisateur;
import kira.formation.auth.demo.repositorories.UtilisateurRepository;
import kira.formation.auth.demo.services.TransactionService;
import kira.formation.auth.demo.services.UtilisateurService;

public class TransactionServiceImpl implements TransactionService{

	private UtilisateurService service;
	
	public TransactionServiceImpl(UtilisateurService service) {
		super();
		this.service = service;
	}
	
	@Override
	public void effectuerTransaction(Utilisateur debiteur, Utilisateur crediteur, double somme) {
		debiteur = this.service.findById(debiteur.getId());
		crediteur = this.service.findById(crediteur.getId());
		effectuerLeVirement(debiteur, crediteur, somme);
		this.service.save(debiteur);
		this.service.save(crediteur);
	}

	private void effectuerLeVirement(Utilisateur debiteur, Utilisateur crediteur, double somme) {
		if (debiteur.getSolde() - somme > 0.0) {
			debiteur.setSolde(debiteur.getSolde() - somme);
			crediteur.setSolde(crediteur.getSolde() + somme);
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}

	@Override
	public void ajouterSolde(Utilisateur utilisateur, double somme) {
		Utilisateur dbUtilisateur = this.service.findById(utilisateur.getId());
		dbUtilisateur.setSolde(dbUtilisateur.getSolde()+somme);
		this.service.save(dbUtilisateur);
	}

}
