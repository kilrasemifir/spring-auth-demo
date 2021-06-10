package kira.formation.auth.demo.utilisateurs.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import kira.formation.auth.demo.utilisateurs.entities.Utilisateur;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{

	public Optional<Utilisateur> findFirstByUsernameOrEmail(String username, String email);
}
