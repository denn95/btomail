package com.bto.mail.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bto.mail.dto.Correo;
import com.bto.mail.dto.MailResponse;
import com.bto.mail.entity.TblCorreo;
import com.bto.mail.interfaz.ICorreoService;
import com.bto.mail.repository.ICorreoRepository;

@Service
public class CorreoService implements ICorreoService{

	@Autowired
	private ICorreoRepository correoRepository;
	
	
	@Override
	public List<Correo> listarCorreosCategoria(Boolean categoria) {
		List<TblCorreo> lst = correoRepository.findByCategoria(categoria);
		List<Correo> listado = entityListToDtoListCat(lst,categoria);
		
		return listado;
	}

	@Override
	public List<Correo> listarCorreosDestacados(Boolean destacado) {
		List<TblCorreo> lst = correoRepository.findByDestacado(destacado);
		List<Correo> listado = entityListToDtoList(lst);
		
		return listado;
	}

	@Override
	public List<Correo> listarCorreosSpam(Boolean spam) {
		List<TblCorreo> lst = correoRepository.findBySpam(spam);
		List<Correo> listado = entityListToDtoList(lst);
		
		return listado;
	}

	@Override
	public List<Correo> listarCorreosEliminados(Boolean eliminado) {
		List<TblCorreo> lst = correoRepository.findByEliminado(eliminado);
		List<Correo> listado = entityListToDtoList(lst);
		
		return listado;
	}

	@Override
	public MailResponse updateDestacado(Correo dto) {
		Optional<TblCorreo> correo = correoRepository.findById(dto.getIdCorreo());
		TblCorreo ent=null;
		if(correo.isPresent()) {
			TblCorreo enti = correo.get();
			enti.setDestacado(dto.getDestacado());
			
			correoRepository.save(enti);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito. Se modificó el campo destacado", ent);
		}else {
		
		return new MailResponse(new Date(), HttpStatus.NOT_FOUND.value(), "Error. No se encontro correo con ID: "+dto.getIdCorreo(), ent);
		
		}
	}

	@Override
	public MailResponse updateSpam(Correo dto) {
		Optional<TblCorreo> correo = correoRepository.findById(dto.getIdCorreo());
		TblCorreo ent=null;
		if(correo.isPresent()) {
			TblCorreo enti = correo.get();
			enti.setSpam(dto.getSpam());
			
			correoRepository.save(enti);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito. Se modificó el campo spam", ent);
		}else {
		
		return new MailResponse(new Date(), HttpStatus.NOT_FOUND.value(), "Error. No se encontro correo con ID: "+dto.getIdCorreo(), ent);
		
		}
	}

	@Override
	public MailResponse updateLeido(Correo dto) {
		Optional<TblCorreo> correo = correoRepository.findById(dto.getIdCorreo());
		TblCorreo ent=null;
		if(correo.isPresent()) {
			TblCorreo enti = correo.get();
			enti.setLeido(dto.getLeido());
			
			correoRepository.save(enti);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito. Se modificó el campo leído", ent);
		}else {
		
		return new MailResponse(new Date(), HttpStatus.NOT_FOUND.value(), "Error. No se encontro correo con ID: "+dto.getIdCorreo(), ent);
		
		}
	}

	@Override
	public MailResponse updateEliminado(Correo dto) {
		Optional<TblCorreo> correo = correoRepository.findById(dto.getIdCorreo());
		TblCorreo ent=null;
		if(correo.isPresent()) {
			TblCorreo enti = correo.get();
			enti.setEliminado(dto.getEliminado());
			
			correoRepository.save(enti);
			return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito. Se modificó el campo eliminado", ent);
		}else {
		
		return new MailResponse(new Date(), HttpStatus.NOT_FOUND.value(), "Error. No se encontro correo con ID: "+dto.getIdCorreo(), ent);
		
		}
	}
	
	public Correo entityToDto(TblCorreo ent) {

		Correo correo = new Correo(ent.getIdCorreo(), ent.getNombreEmisor(),ent.getCorreoEmisor(),
				ent.getFecha(), ent.getAsunto(),ent.getMensaje(),ent.getCategoria(),ent.getLeido(),
				ent.getDestacado(),ent.getEliminado(),ent.getSpam(),ent.getCorreoReceptor());
		
		return correo;
	}
	
	public List<Correo> entityListToDtoList(List<TblCorreo> listado) {

		List<Correo> listadoCorreo = new ArrayList<>();

		for (TblCorreo ent : listado) {

			Correo correo = new Correo(ent.getIdCorreo(), ent.getNombreEmisor(),ent.getCorreoEmisor(),
					ent.getFecha(), ent.getAsunto(),ent.getMensaje(),ent.getCategoria(),ent.getLeido(),
					ent.getDestacado(),ent.getEliminado(),ent.getSpam(),ent.getCorreoReceptor());
			listadoCorreo.add(correo);
		}

		return listadoCorreo;

	}
	public List<Correo> entityListToDtoListCat(List<TblCorreo> listado,Boolean cat) {

		List<Correo> listadoCorreo = new ArrayList<>();

		for (TblCorreo ent : listado) {

			Correo correo = new Correo(ent.getIdCorreo(), ent.getNombreEmisor(),ent.getCorreoEmisor(),
					ent.getFecha(), ent.getAsunto(),ent.getMensaje(),ent.getCategoria(),ent.getLeido(),
					ent.getDestacado(),ent.getEliminado(),ent.getSpam(),ent.getCorreoReceptor());
			if(correo.getCategoria().equals(cat) && correo.getEliminado().equals(false) && correo.getSpam().equals(false)) {
				listadoCorreo.add(correo);
			}
		}

		return listadoCorreo;

	}

	@Override
	public MailResponse save(Correo dto) {
		TblCorreo correo=null;
		
		correo=new TblCorreo(dto.getNombreEmisor(),dto.getCorreoEmisor(),
				dto.getFecha(), dto.getAsunto(),dto.getMensaje(),dto.getCategoria(),dto.getLeido(),
				dto.getDestacado(),dto.getEliminado(),dto.getSpam(),dto.getCorreoReceptor());
		correo = correoRepository.save(correo);
		
		return new MailResponse(new Date(), HttpStatus.OK.value(), "Exito", correo);
	}

	@Override
	public Correo verCorreo(int idCorreo) {
		Correo result = new Correo();

		Optional<TblCorreo> correo = correoRepository.findById(idCorreo);

		if (correo.isPresent()) {
			result = entityToDto(correo.get());
		}

		return result;
	}

	@Override
	public MailResponse eliminar(int idCorreo) {
		
		correoRepository.deleteById(idCorreo);
		
		return new MailResponse(new Date(), HttpStatus.OK.value(), "Se elimino Correctamente", null);
	}

}
