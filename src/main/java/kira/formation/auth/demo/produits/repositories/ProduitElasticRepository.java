package kira.formation.auth.demo.produits.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import kira.formation.auth.demo.produits.documents.elastic.ProduitElastic;

public interface ProduitElasticRepository extends ElasticsearchRepository<ProduitElastic, String> {

	public List<ProduitElastic> findByType(String type);
	
	@Query("{\"bool\":{\"should\":[{\"match\":{\"type\":{\"query\":\"fruit\",\"boost\":3}}},{\"match\":{\"type\":{\"query\":\"Legume\",\"boost\":1.5}}},{\"term\":{\"nom\":{\"value\":\"*sante*\",\"boost\":3}}}],\"must\":[{\"match_all\":{}}]}}")
	public List<ProduitElastic> searchSante();
}
