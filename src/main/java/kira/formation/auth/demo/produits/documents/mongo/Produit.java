package kira.formation.auth.demo.produits.documents.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document()
public class Produit {

	@Id
	private String id;
	
	private String nom;
	private String type;
	private int quantite;
	private String description;
	
}
