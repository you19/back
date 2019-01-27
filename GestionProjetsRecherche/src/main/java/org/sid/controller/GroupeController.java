package org.sid.controller;

import java.util.List;

import org.sid.metier.GroupeMetier;
import org.sid.model.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/groupes")
public class GroupeController {
	
	@Autowired
	private GroupeMetier groupeMetier;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Groupe saveGroupe(Groupe g) {
		return groupeMetier.saveGroupe(g);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Groupe> groupes(){
		return groupeMetier.groupes();
	}
	
	@RequestMapping(value="/groupe/{idGroupe}",method=RequestMethod.GET)
	public Groupe getGroupe(@PathVariable Long idGroupe) {
		return groupeMetier.getGroupe(idGroupe);
	}
	
	@RequestMapping(value="/delete/{idGroupe}",method=RequestMethod.DELETE)
	public boolean deleteGroupe(@PathVariable Long idGroupe) {
		groupeMetier.deleteGroupe(idGroupe);
		return true;
	}
}
