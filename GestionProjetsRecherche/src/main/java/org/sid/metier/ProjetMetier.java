package org.sid.metier;

import java.util.List;

import org.sid.model.Agenda;
import org.sid.model.DepotDoc;
import org.sid.model.Discussion;
import org.sid.model.Groupe;
import org.sid.model.Projet;
import org.sid.model.Ressource;
import org.sid.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjetMetier {
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private GroupeMetier groupeMetier;
	@Autowired
	private RessourceMetier ressourceMetier;
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	
	public Projet saveProjet(Projet p) {
		return projetRepository.save(p);
	}
	
	public boolean validerProjet(Long idProjet) {
		Projet p = this.getProjet(idProjet);
		p.setValide(true);
		System.out.println("nom "+p.getNomCourt());
		Groupe g1 = new Groupe(p.getNomCourt(), p);
		groupeMetier.saveGroupe(g1);
		Groupe g2 = new Groupe(p.getNomCourt()+"_adm", p);
		groupeMetier.saveGroupe(g2);
		
		if(p.getProp()!=null) {
			System.out.println("**********************"+p.getProp().getNom());
		p.getProp().setGroupe(g2);
		utilisateurMetier.saveUtilisateur(p.getProp());
		projetRepository.save(p);
		}
		
		Ressource dd1 = new DepotDoc("src", p);
		Ressource dd2 = new DepotDoc("web", p);
		Ressource d1 = new Discussion(p.getNomCourt(), p);
		Ressource d2 = new Discussion(p.getNomCourt()+"_adm", p);
		Ressource a = new Agenda(p.getNomCourt()+"_agenda", p, null);
		ressourceMetier.saveRessource(dd1);
		ressourceMetier.saveRessource(dd2);
		ressourceMetier.saveRessource(d1);
		ressourceMetier.saveRessource(d2);
		ressourceMetier.saveRessource(a);
		return true;
	}
	
	public Projet getProjet(Long idProjet) {
		return projetRepository.findOne(idProjet);
	}
	
	public List<Projet> projets(){
		return projetRepository.findAll();
	}
	
	public boolean deleteProjet(Long idProjet) {
		projetRepository.deleteById(idProjet);
		return true;
	}
}
