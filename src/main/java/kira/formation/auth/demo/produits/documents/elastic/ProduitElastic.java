package kira.formation.auth.demo.produits.documents.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "produits")
public class ProduitElastic {
	@Id
	private String id;
	
	private String nom;
	private String type;
	private int quantite;
	private String description;
}
