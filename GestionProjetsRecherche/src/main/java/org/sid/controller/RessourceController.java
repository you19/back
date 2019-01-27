package org.sid.controller;

import java.util.List;

import org.sid.metier.RessourceMetier;
import org.sid.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/ressources")
public class RessourceController {
	
	@Autowired
	private RessourceMetier ressourceMetier;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Ressource saveRessource(@RequestBody Ressource r) {
		return ressourceMetier.saveRessource(r);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Ressource> ressources(){
		return ressourceMetier.ressources();
	}
	
	@RequestMapping(value="delete/{idRes}",method=RequestMethod.DELETE)
	public boolean deleteRessource(@PathVariable Long idRes) {
		return ressourceMetier.deleteRessource(idRes);
	}
}
