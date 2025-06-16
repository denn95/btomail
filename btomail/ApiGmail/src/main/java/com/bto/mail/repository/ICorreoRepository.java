package com.bto.mail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bto.mail.entity.TblCorreo;

public interface ICorreoRepository extends JpaRepository<TblCorreo, Integer>{
	public List<TblCorreo> findByCategoria(boolean categoria);
	public List<TblCorreo> findByDestacado(boolean destacado);
	public List<TblCorreo> findBySpam(boolean spam);
	public List<TblCorreo> findByEliminado(boolean eliminado);
}
