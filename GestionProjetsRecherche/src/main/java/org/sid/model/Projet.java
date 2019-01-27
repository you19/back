package org.sid.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	@Id @GeneratedValue
	private Long idProjet;
	private String nomCourt;
	private String nomLong;
	private String description;
	private String theme;
	private boolean valide;
	private boolean type;
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="prop")
	private Utilisateur prop;
	@OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
	private Collection<Groupe> groupes;
	@OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
	private Collection<DepotDoc> docs;
	@OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
	private Collection<Discussion> discussions;
	@OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
	private Collection<Agenda> agendas;
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projet(String nomCourt, String nomLong, String description, String theme, boolean type) {
		super();
		this.nomCourt = nomCourt;
		this.nomLong = nomLong;
		this.description = description;
		this.theme = theme;
		this.type = type;
	}
	public Projet(String nomCourt, String nomLong, String description, String theme, boolean type, Utilisateur prop) {
		super();
		this.nomCourt = nomCourt;
		this.nomLong = nomLong;
		this.description = description;
		this.theme = theme;
		this.type = type;
		this.prop = prop;
	}
	public Long getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}
	public String getNomCourt() {
		return nomCourt;
	}
	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}
	public String getNomLong() {
		return nomLong;
	}
	public void setNomLong(String nomLong) {
		this.nomLong = nomLong;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public Utilisateur getProp() {
		return prop;
	}
	public void setProp(Utilisateur prop) {
		this.prop = prop;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	@JsonIgnore
	public Collection<DepotDoc> getDocs() {
		return docs;
	}
	public void setDocs(Collection<DepotDoc> docs) {
		this.docs = docs;
	}
	@JsonIgnore
	public Collection<Discussion> getDiscussions() {
		return discussions;
	}
	public void setDiscussions(Collection<Discussion> discussions) {
		this.discussions = discussions;
	}
	@JsonIgnore
	public Collection<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(Collection<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	

}
