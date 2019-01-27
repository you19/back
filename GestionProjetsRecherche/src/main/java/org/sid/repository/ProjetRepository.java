package org.sid.repository;

import org.sid.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjetRepository extends JpaRepository<Projet, Long>{
	@Query("select c from Projet c where c.idProjet like :idProjet")
	Projet findOne(@Param("idProjet")Long idProjet);
	

}
