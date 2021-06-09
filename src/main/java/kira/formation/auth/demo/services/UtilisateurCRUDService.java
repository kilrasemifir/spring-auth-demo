package kira.formation.auth.demo.services;

import kira.formation.auth.demo.models.Utilisateur;

public interface UtilisateurCRUDService extends GenericCRUDService<Utilisateur> {

	void deleteById(String id);

}