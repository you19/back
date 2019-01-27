package org.sid.metier;

import java.util.List;

import org.sid.model.Groupe;
import org.sid.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupeMetier {
	@Autowired
	private GroupeRepository groupeRepository;
	
	public Groupe saveGroupe(Groupe g) {
		return groupeRepository.save(g);
	}
	
	public List<Groupe> groupes(){
		return groupeRepository.findAll();
	}
	
	public Groupe getGroupe(Long idGroupe) {
		return groupeRepository.findOne(idGroupe);
	}
	
	public boolean deleteGroupe(Long idGroupe) {
		groupeRepository.deleteById(idGroupe);
		return true;
	}

}
