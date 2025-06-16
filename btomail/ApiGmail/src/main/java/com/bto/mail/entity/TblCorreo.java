package com.bto.mail.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CORREO")
public class TblCorreo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCorreo", nullable = false)
	private Integer idCorreo;
	
	@Column(name="nombreEmisor", nullable = false)
	private String nombreEmisor;
	
	@Column(name="correoEmisor", nullable = false)
	private String correoEmisor;
	
	@Column(name="fecha", nullable = false)
	private Date fecha;
	
	@Column(name="asunto", nullable = false)
	private String asunto;
	
	@Column(name="mensaje", nullable = false)
	private String mensaje;
	
	@Column(name="categoria", nullable = false)
	private Boolean categoria;
	
	@Column(name="leido", nullable = false)
	private Boolean leido;
	
	@Column(name="destacado", nullable = false)
	private Boolean destacado;
	
	@Column(name="eliminado", nullable = false)
	private Boolean eliminado;
	
	@Column(name="spam", nullable = false)
	private Boolean spam;
	
	@Column(name="correoReceptor", nullable = false)
	private String correoReceptor;
	
	public TblCorreo() {
		// TODO Auto-generated constructor stub
	}

	public TblCorreo(String nombreEmisor, String correoEmisor, Date fecha, String asunto,
			String mensaje, Boolean categoria, Boolean leido, Boolean destacado, Boolean eliminado, Boolean spam,
			String correoReceptor) {
		super();
		this.nombreEmisor = nombreEmisor;
		this.correoEmisor = correoEmisor;
		this.fecha = fecha;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.categoria = categoria;
		this.leido = leido;
		this.destacado = destacado;
		this.eliminado = eliminado;
		this.spam = spam;
		this.correoReceptor = correoReceptor;
	}

	public Integer getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(Integer idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getNombreEmisor() {
		return nombreEmisor;
	}

	public void setNombreEmisor(String nombreEmisor) {
		this.nombreEmisor = nombreEmisor;
	}

	public String getCorreoEmisor() {
		return correoEmisor;
	}

	public void setCorreoEmisor(String correoEmisor) {
		this.correoEmisor = correoEmisor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getCategoria() {
		return categoria;
	}

	public void setCategoria(Boolean categoria) {
		this.categoria = categoria;
	}

	public Boolean getLeido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}

	public Boolean getDestacado() {
		return destacado;
	}

	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Boolean getSpam() {
		return spam;
	}

	public void setSpam(Boolean spam) {
		this.spam = spam;
	}

	public String getCorreoReceptor() {
		return correoReceptor;
	}

	public void setCorreoReceptor(String correoReceptor) {
		this.correoReceptor = correoReceptor;
	}

	
}
