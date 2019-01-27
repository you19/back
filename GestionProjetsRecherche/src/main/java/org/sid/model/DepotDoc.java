package org.sid.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@DiscriminatorValue("DepotDoc")
public class DepotDoc extends Ressource{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomDD;
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="projet")
	private Projet projet;
	public DepotDoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepotDoc(String nomDD, Projet projet) {
		super();
		this.nomDD = nomDD;
		this.projet = projet;
	}
	public String getNomDD() {
		return nomDD;
	}
	public void setNomDD(String nomDD) {
		this.nomDD = nomDD;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
}
