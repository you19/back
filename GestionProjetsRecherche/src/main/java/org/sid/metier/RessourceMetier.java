package org.sid.metier;

import java.util.List;

import org.sid.model.Ressource;
import org.sid.repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RessourceMetier {
	@Autowired
	private RessourceRepository ressourceRepository;
	
	public Ressource saveRessource(Ressource r) {
		return ressourceRepository.save(r);
	}
	
	public List<Ressource> ressources(){
		return ressourceRepository.findAll();
	}
	
	public boolean deleteRessource(Long idRes) {
		ressourceRepository.deleteById(idRes);
		return true;
	}

}
