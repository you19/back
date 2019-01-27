package org.sid.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@DiscriminatorValue("Discussion")
public class Discussion extends Ressource{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomDisc;
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="projet")	
	private Projet projet;
	public Discussion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Discussion(String nomDisc, Projet projet) {
		super();
		this.nomDisc = nomDisc;
		this.projet = projet;
	}
	public String getNomDisc() {
		return nomDisc;
	}
	public void setNomDisc(String nomDisc) {
		this.nomDisc = nomDisc;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
