package kira.formation.auth.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import kira.formation.auth.demo.dto.SimpleUtilisateurDTO;
import kira.formation.auth.demo.models.Utilisateur;
import kira.formation.auth.demo.repositorories.UtilisateurRepository;
import kira.formation.auth.demo.services.SimpleUtilisateurService;
import kira.formation.auth.demo.services.UtilisateurService;

public class SimpleUtilisateurServiceImpl implements SimpleUtilisateurService{

	private ObjectMapper mapper;
	private UtilisateurRepository repository;
	private UtilisateurService utilisateurService;

	public SimpleUtilisateurServiceImpl(ObjectMapper mapper, UtilisateurRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public List<SimpleUtilisateurDTO> trouverToutLesUtilisateurs() {
		List<Utilisateur> utilisateurs = this.repository.findAll();
		
		/*
		return utilisateurs.stream().map(utilisateur->{
			return this.mapper.convertValue(utilisateur, SimpleUtilisateurDTO.class);
		}).collect(Collectors.toList());
		*/
		List<SimpleUtilisateurDTO> results = new ArrayList<>();
		for (Utilisateur utilisateur : utilisateurs) {
			results.add(this.mapper.convertValue(utilisateur, SimpleUtilisateurDTO.class));
		}
		return results;
	}
	
	public SimpleUtilisateurDTO findSimpleUtilisateurById(String id) {
		Utilisateur utilisateur = this.utilisateurService.findById(id);
		return mapper.convertValue(utilisateur, SimpleUtilisateurDTO.class);
	}
}
