package com.bto.mail.dto;

import java.util.Date;

public class MailResponse {
	
	private Date timestamp;
	private Integer status;
	private String mensaje;
	private Object data;
	
	public MailResponse() {
		// TODO Auto-generated constructor stub
	}

	public MailResponse(Date timestamp, Integer status, String mensaje, Object data) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.mensaje = mensaje;
		this.data = data;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
