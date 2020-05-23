package com.uca.capas.preparcial.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.OneToOne;

@Entity
@Table(schema = "public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name = "c_contribuyente")
	@GeneratedValue(generator = "contribuyente_c_contribuyente_seq",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq",sequenceName = "public.contribuyente_c_contribuyente_seq",allocationSize = 1)
	private Integer ccontribuyente;
	
	//RELACION
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia",unique = true, insertable = false, updatable = false)
	private Importancia importancia;
	
	@Column(name = "s_nombre")
	@Size(message = "El campo Nombre debe tener entre 1 y 30 caracteres",min=1,max = 30)
	private String 	snombre;
	
	@Column(name = "s_apellido")
	@Size(message = "El campo Apellido debe tener entre 1 y 30 caracteres",min=1,max = 30)
	private String  sapellido;
	
	@Column(name = "s_nit")
	@Size(message = "El campo Nit debe tener entre 1 y 14 caracteres",min=1,max = 14)
	private String	snit;
	
	@Column(name = "f_fecha_ingreso")
	private Date	ffechaingreso;
	
	@Column(name = "c_importancia")
	@NotNull(message = "Debe seleccionar una opcion")
	private Integer cimportancia; 
	
	
	public Integer getCcontribuyente() {
		return ccontribuyente;
	}

	public void setCcontribuyente(Integer ccontribuyente) {
		this.ccontribuyente = ccontribuyente;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public String getSnombre() {
		return snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
	}

	public String getSnit() {
		return snit;
	}

	public void setSnit(String snit) {
		this.snit = snit;
	}

	public Date getFfechaingreso() {
		return ffechaingreso;
	}

	public void setFfechaingreso(Date ffechaingreso) {
		this.ffechaingreso = ffechaingreso;
	}

	public Integer getCimportancia() {
		return cimportancia;
	}

	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}
	
	
}
