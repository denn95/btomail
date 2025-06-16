package com.bto.mail.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import com.bto.mail.dto.MailResponse;

@ControllerAdvice
public class ExceptionGlobalResponse {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionGlobalResponse.class);
	
	MailResponse result;
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<MailResponse> runtimeException(RuntimeException e) {
		
		result = new MailResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error: " + e.getMessage(), null);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MailResponse> exception(Exception e) {
		result = new MailResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error: " + e.getMessage(), null);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<MailResponse> clientErrorException(HttpClientErrorException e) {
		
		LOGGER.error("OCURRIO UN ERROR DE AUTENTICACION");
		
		String mensaje = "Ocurrio un Error consumiendo el Servicio";
		if(e.getRawStatusCode() == 403) {
			mensaje = "Ocurrio un error autenticando el usuario";
		}
		
		result = new MailResponse(new Date(), e.getRawStatusCode(), mensaje, null);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
