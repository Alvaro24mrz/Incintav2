package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PreguntasGestante")
public class PreguntasGestante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPreguntasGestante;
	
	//el fk
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombreTitulo", length=60, nullable=false)
	private String nTitulo;
	
	@Column(name="nombrePregunta", length=60, nullable=false)
	private String tPregunta;
	
	@Column(name="fecha", length=60, nullable=false)
	private Date fecha;

	public PreguntasGestante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreguntasGestante(int idPreguntasGestante, int idUsuario, String nTitulo, String tPregunta, Date fecha) {
		super();
		this.idPreguntasGestante = idPreguntasGestante;
		this.idUsuario = idUsuario;
		this.nTitulo = nTitulo;
		this.tPregunta = tPregunta;
		this.fecha = fecha;
	}

	public int getIdPreguntasGestante() {
		return idPreguntasGestante;
	}

	public void setIdPreguntasGestante(int idPreguntasGestante) {
		this.idPreguntasGestante = idPreguntasGestante;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getnTitulo() {
		return nTitulo;
	}

	public void setnTitulo(String nTitulo) {
		this.nTitulo = nTitulo;
	}

	public String gettPregunta() {
		return tPregunta;
	}

	public void settPregunta(String tPregunta) {
		this.tPregunta = tPregunta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

}
