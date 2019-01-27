package org.sid.repository;

import org.sid.model.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupeRepository extends JpaRepository<Groupe, Long>{
	@Query("select c from Groupe c where c.idGroupe like :idGroupe")
	Groupe findOne(@Param("idGroupe")Long idGroupe);

}
