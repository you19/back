package org.sid.repository;

import org.sid.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{
	@Query("select c from Utilisateur c where c.id like :id")
	public Utilisateur getByID(@Param("id") String id);


}
