package com.bto.mail.interfaz;

import java.util.List;

import com.bto.mail.dto.Correo;
import com.bto.mail.dto.MailResponse;

public interface ICorreoService {
	public List<Correo> listarCorreosCategoria(Boolean categoria);
	
	public List<Correo> listarCorreosDestacados(Boolean destacado);
	
	public List<Correo> listarCorreosSpam(Boolean spam);
	
	public List<Correo> listarCorreosEliminados(Boolean eliminado);
	
	public MailResponse updateDestacado(Correo correo);
	
	public MailResponse updateSpam(Correo correo);
	
	public MailResponse updateLeido(Correo correo);
	
	public MailResponse updateEliminado(Correo correo);
	
	public MailResponse save(Correo correo);
	
	public Correo verCorreo(int idCorreo);
	
	public MailResponse eliminar(int idCorreo);
}
