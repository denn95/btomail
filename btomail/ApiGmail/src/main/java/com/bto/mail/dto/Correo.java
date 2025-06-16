package com.bto.mail.dto;

import java.util.Date;

public class Correo {
	private int idCorreo;
	private String nombreEmisor;
	private String correoEmisor;
	private Date fecha;
	private String asunto;
	private String mensaje;
	private Boolean categoria;
	private Boolean leido;
	private Boolean destacado;
	private Boolean eliminado;
	private Boolean spam;
	private String correoReceptor;
	
	public Correo() {
		// TODO Auto-generated constructor stub
	}

	public Correo(int idCorreo, String nombreEmisor, String correoEmisor, Date fecha, String asunto, String mensaje,
			Boolean categoria, Boolean leido, Boolean destacado, Boolean eliminado, Boolean spam,
			String correoReceptor) {
		super();
		this.idCorreo = idCorreo;
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

	public int getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
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
