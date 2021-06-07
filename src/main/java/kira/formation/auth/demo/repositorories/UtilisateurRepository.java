package kira.formation.auth.demo.repositorories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import kira.formation.auth.demo.models.Utilisateur;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{

	public Optional<Utilisateur> findFirstByUsernameOrEmail(String username, String email);
}
