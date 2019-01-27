package org.sid;

import org.sid.metier.GroupeMetier;
import org.sid.metier.ProjetMetier;
import org.sid.metier.UtilisateurMetier;
import org.sid.model.Groupe;
import org.sid.model.Projet;
import org.sid.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionProjetsRechercheApplication implements CommandLineRunner{
	@Autowired
	private GroupeMetier groupeMetier;
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private ProjetMetier projetMetier;

	public static void main(String[] args) {
		SpringApplication.run(GestionProjetsRechercheApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*Projet p = projetMetier.getProjet(new Long((2)));
		Projet p2 = projetMetier.getProjet(new Long((4)));
       Groupe admin1 = new Groupe("SD",p); Groupe guest1 = new Groupe("SD2",p2);
		  Groupe defaults = new Groupe("Defaults");
		  Groupe admin = new Groupe("admin");
		  Groupe guest = new Groupe("guest");

	groupeMetier.saveGroupe(admin); 
	 groupeMetier.saveGroupe(guest);
	 groupeMetier.saveGroupe(defaults);	
	 Utilisateur u1 = new Utilisateur("user0", "alami", "Ahmed",
	 "ahmed.alami@gmail.com", "aze123"); 
	 Utilisateur u2 = new Utilisateur("guest","guest", "guest", null, "guest", guest);
	 Utilisateur u3 = new Utilisateur("admin", "admin", "admin", null, "admin", admin);
		
		 utilisateurMetier.saveUtilisateur(u1); utilisateurMetier.saveUtilisateur(u2);
		 utilisateurMetier.saveUtilisateur(u3);
		  
		 Utilisateur prop = utilisateurMetier.getUtilisateur("user0"); Projet p1 = new
		  Projet("PJEE", "projet_Java_Web", "application des api JEE", "education",
	false, prop); projetMetier.saveProjet(p1);
//		 
//		
		Long a = new Long(1);
		System.out.println("a = "+a);
		Projet p = projetMetier.getProjet(a);
		projetMetier.validerProjet(p.getIdProjet());
		
		Utilisateur u1 = new Utilisateur("userS", "aniber", "youssef","y.aniber@gmail.com", "azerty");
	utilisateurMetier.saveUtilisateur(u1);
		Utilisateur u2 = new Utilisateur("user1", "charrafi", "yassine","y.charrafi@gmail.com", "azerty");
		utilisateurMetier.saveUtilisateur(u2);
		Utilisateur u3 = new Utilisateur("user2", "rizki", "salma","s.rizki@gmail.com", "azerty");
		utilisateurMetier.saveUtilisateur(u3);
		Utilisateur u4 = new Utilisateur("user3", "erraki", "mohamed","m.erraki@gmail.com", "azerty");
		utilisateurMetier.saveUtilisateur(u4);
		Utilisateur u5 = new Utilisateur("user4", "alami", "safaa","s.alami@gmail.com", "azerty");
		utilisateurMetier.saveUtilisateur(u5);*/
		
		
	}
}
