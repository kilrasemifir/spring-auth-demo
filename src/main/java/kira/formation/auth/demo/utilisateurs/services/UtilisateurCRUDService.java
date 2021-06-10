package kira.formation.auth.demo.utilisateurs.services;

import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;

public interface UtilisateurCRUDService extends GenericCRUDService<Utilisateur> {

	void deleteById(String id);

}