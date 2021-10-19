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

import pe.edu.upc.spring.model.Parametro;
import pe.edu.upc.spring.model.Usuario;



@Entity
@Table(name="Registro")
public class Registro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegistro;
	
	
	/*
	 * 
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario idUsuario;
	 * 
	 * */
	
	
	@Column(name="fecha", nullable=false)
	private Date fechaFicha;
	
	@Column(name="anotaciones", nullable=true)
	private String tAnotaciones; 
	
	
	/*
	@ManyToOne
	@JoinColumn(name="idParametro", nullable=false)
	private Parametro idParametro;
	 */
	
	@Column(name="valor", nullable=false)
	private int numValor;
	
	
	
	

	public Registro() {
		super();
	}





	public Registro(int idRegistro, Date fechaFicha, String tAnotaciones, int numValor) {
		super();
		this.idRegistro = idRegistro;
		this.fechaFicha = fechaFicha;
		this.tAnotaciones = tAnotaciones;
		this.numValor = numValor;
	}





	public int getIdRegistro() {
		return idRegistro;
	}


	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Date getFechaFicha() {
		return fechaFicha;
	}


	public void setFechaFicha(Date fechaFicha) {
		this.fechaFicha = fechaFicha;
	}


	public String gettAnotaciones() {
		return tAnotaciones;
	}

	public void settAnotaciones(String tAnotaciones) {
		this.tAnotaciones = tAnotaciones;
	}

	public int getNumValor() {
		return numValor;
	}


	public void setNumValor(int numValor) {
		this.numValor = numValor;
	}



	


	

	
	
	
	
}
