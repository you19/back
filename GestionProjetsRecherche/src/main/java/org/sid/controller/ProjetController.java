package org.sid.controller;

import java.util.List;

import org.sid.metier.ProjetMetier;
import org.sid.model.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
@RequestMapping("projet")
public class ProjetController {
	@Autowired
	private ProjetMetier projetMetier;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Projet saveProjet(@RequestBody Projet p) {
		return projetMetier.saveProjet(p);
	}
	
	@RequestMapping(value="/valider/{idProjet}",method=RequestMethod.GET)
	public boolean validerProjet(@PathVariable Long idProjet) {
		return projetMetier.validerProjet(idProjet);
	}
	
	@RequestMapping(value="projet/{idProjet}",method=RequestMethod.GET)
	public Projet getProjet(@PathVariable Long idProjet) {
		return projetMetier.getProjet(idProjet);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Projet> projets(){
		return projetMetier.projets();
	}
	
	@RequestMapping(value="delete/{idProjet}",method=RequestMethod.DELETE)
	public boolean deleteProjet(@PathVariable Long idProjet) {
		return projetMetier.deleteProjet(idProjet);
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public Projet Projet(@PathVariable Long id ,@RequestBody Projet p){
		p.setIdProjet(id);
		return projetMetier.saveProjet(p);
	}

}
