package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.edu.upc.spring.model.Usuario;



@Entity
@Table(name="PeriodoGestacion")
public class PeriodoGestacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPeriodo;
	
	
	/*
	 * 
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario idUsuario;
	 * 
	 * */
	
	
	@Column(name="fechaActualizacion", nullable=false)
	private Date fechaActualizacion;
	
	
	@Column(name="semana", nullable=false)
	private int numSemana;
	
	
	
	

	public PeriodoGestacion() {
		super();
	}





	public PeriodoGestacion(int idPeriodo, Date fechaActualizacion, int numSemana) {
		super();
		this.idPeriodo = idPeriodo;
		this.fechaActualizacion = fechaActualizacion;
		this.numSemana = numSemana;
	}





	public int getIdPeriodo() {
		return idPeriodo;
	}


	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}


	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}


	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	public int getNumSemana() {
		return numSemana;
	}

	public void setNumSemana(int numSemana) {
		this.numSemana = numSemana;
	}
	
	
}
