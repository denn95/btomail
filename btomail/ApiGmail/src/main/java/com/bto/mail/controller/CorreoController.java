package com.bto.mail.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bto.mail.dto.Correo;
import com.bto.mail.dto.MailResponse;
import com.bto.mail.interfaz.ICorreoService;

@RestController
@CrossOrigin
public class CorreoController {
	
	@Autowired
	private ICorreoService correoService;
	
	@GetMapping(value = "/Correo/{categoria}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse getCorreosCategoria(@PathVariable(name = "categoria") Boolean categoria) {

		
			List<Correo> lista = correoService.listarCorreosCategoria(categoria);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito", lista);
		
	}
	
	@GetMapping(value="/Correo/Detalle/{correoId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public MailResponse getPedido(@PathVariable(name="correoId") Integer correoId){
		Correo correo = correoService.verCorreo(correoId);
		return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito", correo);
	}
	
	@GetMapping(value = "/Correo/Destacado/{destacado}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse getCorreosDestacados(@PathVariable(name = "destacado") Boolean destacado) {

		
			List<Correo> lista = correoService.listarCorreosDestacados(destacado);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito", lista);
		
	}
	@GetMapping(value = "/Correo/Spam/{spam}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse getCorreosSpam(@PathVariable(name = "spam") Boolean spam) {

			List<Correo> lista = correoService.listarCorreosSpam(spam);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito", lista);
		
	}
	@GetMapping(value = "/Correo/Eliminado/{eliminado}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse getCorreosEliminados(@PathVariable(name = "eliminado") Boolean eliminado) {

			List<Correo> lista = correoService.listarCorreosEliminados(eliminado);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito", lista);
		
	}
	
	
	@PutMapping(value = "/Correo/Destacado", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse updateCorreoDestacado(@RequestBody Correo correo) {
		
			MailResponse resp = correoService.updateDestacado(correo);

			return new MailResponse(new Date(), resp.getStatus(), resp.getMensaje(), resp.getData());
		
	}
	@PutMapping(value = "/Correo/Spam", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse updateCorreoSpam(@RequestBody Correo correo) {
		
			MailResponse resp = correoService.updateSpam(correo);

			return new MailResponse(new Date(), resp.getStatus(), resp.getMensaje(), resp.getData());
		
	}
	@PutMapping(value = "/Correo/Eliminado", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse updateCorreoEliminado(@RequestBody Correo correo) {
		
			MailResponse resp = correoService.updateEliminado(correo);

			return new MailResponse(new Date(), resp.getStatus(), resp.getMensaje(), resp.getData());
		
	}
	@PutMapping(value = "/Correo/Leido", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse updateCorreoLeido(@RequestBody Correo correo) {
	
			MailResponse resp = correoService.updateLeido(correo);

			return new MailResponse(new Date(), resp.getStatus(), resp.getMensaje(), resp.getData());
		
	}
	@PostMapping(value = "/Correo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MailResponse saveCorreo(@RequestBody Correo correo) {
		
		MailResponse resp = correoService.save(correo);
			return new MailResponse(new Date(), resp.getStatus(), resp.getMensaje(), resp.getData());
		
	}
	
	@DeleteMapping(value="/Correo/{correoId}")
	public MailResponse deleteCorreo(@PathVariable(name="correoId") Integer correoId) {
		MailResponse resp = correoService.eliminar(correoId);
		return new MailResponse(new Date(), resp.getStatus(), resp.getMensaje(), resp.getData());
	}

}
