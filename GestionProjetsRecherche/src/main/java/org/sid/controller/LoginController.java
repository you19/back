package org.sid.controller;

import org.sid.model.Utilisateur;
import org.sid.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@PostMapping(value="/login",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin
	public Utilisateur login(@RequestBody Utilisateur user) {
		if(user!=null) {
			System.err.println("11111111111111");
			System.err.println("id:"+user.getId());
			Utilisateur u = utilisateurRepository.getByID(user.getId());
			System.err.println("password: "+u.getPassword());
			if(u!=null) {
				System.err.println("222222222222222");
				if(u.getPassword().equals(user.getPassword())) {
					
					user=u;
				}
				else
					user = null;
			}
			
		}
		return user;
	}

}
