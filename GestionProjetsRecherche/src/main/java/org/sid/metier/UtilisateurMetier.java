package org.sid.metier;

import java.util.List;

import org.sid.model.Agenda;
import org.sid.model.Ressource;
import org.sid.model.Utilisateur;
import org.sid.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurMetier {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private GroupeMetier groupeMetier;
	@Autowired
	private RessourceMetier ressourceMetier;
	
	public Utilisateur saveUtilisateur(Utilisateur u) {
		Ressource a1 = new Agenda(u.getNom()+"_Agenda", null, u);
		ressourceMetier.saveRessource(a1);
		u.setEtat(true);
		if(u.getGroupe()==null)
		u.setGroupe(groupeMetier.getGroupe((long) 3));
		return utilisateurRepository.save(u);
	}
	
	public Utilisateur getUtilisateur(String id) {
		return utilisateurRepository.getByID(id);
	}
	
	public List<Utilisateur> utilisateurs(){
		return utilisateurRepository.findAll();
	}
	
	public boolean deleteUtilisateur(String id) {
		utilisateurRepository.deleteById(id);
		return true;
	}

}
