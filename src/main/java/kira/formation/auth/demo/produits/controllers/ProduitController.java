package kira.formation.auth.demo.produits.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kira.formation.auth.demo.produits.documents.mongo.Produit;
import kira.formation.auth.demo.produits.services.ProduitService;

@RestController
@RequestMapping("produits")
@CrossOrigin
public class ProduitController {

	@Autowired
	private ProduitService service;

	@PostMapping("")
	public Produit save(@RequestBody Produit entity) {
		return service.save(entity);
	}

	@GetMapping("{id}")
	public Optional<Produit> findById(@PathVariable String id) {
		return service.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}

	@GetMapping("")
	public List<Produit> findAll() {
		return service.findAll();
	}

	@GetMapping("type/{type}")
	public List<Produit> findByType(@PathVariable String type) {
		return service.findByType(type);
	}

	@GetMapping("sante")
	public List<Produit> searchSante() {
		return service.searchSante();
	}
	
	
	
}
