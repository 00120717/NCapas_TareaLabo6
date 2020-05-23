package com.uca.capas.preparcial.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name="importancia")
public class Importancia {
	
	@Id
	@Column(name = "c_importancia")
	@GeneratedValue(generator = "importancia_c_importancia_seq",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "importancia_c_importacia_seq",sequenceName = "public.importancia_c_importancia_seq")
	private Integer cimportancia;
	
	@Column(name = "s_importancia")
	private String simportancia;
	
	//RELACION
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "importancia")
	private List<Contribuyente> contribuyentes;

	public Integer getCimportancia() {
		return cimportancia;
	}

	public void setCimportancia(Integer cImportancia) {
		this.cimportancia = cImportancia;
	}

	public String getSimportancia() {
		return simportancia;
	}

	public void setSimportancia(String sImportancia) {
		this.simportancia = sImportancia;
	}

	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}
	
	
}
