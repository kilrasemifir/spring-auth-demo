package kira.formation.auth.demo.produits.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.produits.documents.elastic.ProduitElastic;
import kira.formation.auth.demo.produits.documents.mongo.Produit;
import kira.formation.auth.demo.produits.repositories.ProduitElasticRepository;
import kira.formation.auth.demo.produits.repositories.ProduitMongoRepository;

@Service
public class ProduitService {

	ObjectMapper mapper;
	
	private ProduitMongoRepository mongoRepository;

	private ProduitElasticRepository elasticRepository;
	
	public ProduitService(ObjectMapper mapper, ProduitMongoRepository mongoRepository,
			ProduitElasticRepository elasticRepository) {
		this.mapper = mapper;
		this.mongoRepository = mongoRepository;
		this.elasticRepository = elasticRepository;
	}

	public Produit save(Produit entity) {
		Produit result = mongoRepository.save(entity);
		elasticRepository.save(mapper.convertValue(result,ProduitElastic.class));
		return result;
	}

	public List<Produit> findAll() {
		return mongoRepository.findAll();
	}

	public Optional<Produit> findById(String id) {
		return mongoRepository.findById(id);
	}

	public void deleteById(String id) {
		mongoRepository.deleteById(id);
	}

	public List<Produit> findByType(String type) {
		List<ProduitElastic> produitsElastic = elasticRepository.findByType(type);
		List<String> ids = produitsElastic.stream()
				.map(produit->produit.getId())
				.collect(Collectors.toList());
		return mongoRepository.findAllById(ids);
//		for (ProduitElastic produitElastic : produitsElastic) {
//			results.add(mongoRepository.findById(produitElastic.getId()).get());
//		}
//		return results;
	}

	public List<Produit> searchSante() {
		List<Produit> results = new ArrayList<>();
		List<ProduitElastic> produitsElastic = elasticRepository.searchSante();
		for (ProduitElastic produitElastic : produitsElastic) {
			results.add(mongoRepository.findById(produitElastic.getId()).get());
		}
		return results;
	}
	
	
	
	
}
