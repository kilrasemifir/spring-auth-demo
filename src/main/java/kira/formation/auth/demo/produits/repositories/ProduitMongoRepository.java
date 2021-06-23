package kira.formation.auth.demo.produits.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import kira.formation.auth.demo.produits.documents.mongo.Produit;

public interface ProduitMongoRepository extends MongoRepository<Produit, String>{

	List<Produit> findAllById(Iterable<String> ids);
}
