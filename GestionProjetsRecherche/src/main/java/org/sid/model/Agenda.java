package org.sid.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@DiscriminatorValue("Agenda")
public class Agenda extends Ressource{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomAgenda;
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="projet")
	private Projet projet;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="utilisateur")
	private Utilisateur utilisateur;
	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agenda(String nomAgenda, Projet projet, Utilisateur utilisateur) {
		super();
		this.nomAgenda = nomAgenda;
		this.projet = projet;
		this.utilisateur = utilisateur;
	}
	public String getNomAgenda() {
		return nomAgenda;
	}
	public void setNomAgenda(String nomAgenda) {
		this.nomAgenda = nomAgenda;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
