package org.sid.controller;

import java.util.List;

import org.sid.metier.UtilisateurMetier;
import org.sid.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/users")
public class UtilisateurController {
	@Autowired
	private UtilisateurMetier user;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur u) {
		return user.saveUtilisateur(u);
	}
	
	@RequestMapping(value="user/{id}",method=RequestMethod.GET)
	public Utilisateur getUtilisateur(@PathVariable String id) {
		return user.getUtilisateur(id);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Utilisateur> utilisateurs(){
		return user.utilisateurs();
	}
	
	@RequestMapping(value="/delete/{id}")
	public boolean deleteUtilisateur(@PathVariable String id) {
		return user.deleteUtilisateur(id);
	}
}
