package com.uca.capas.preparcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.preparcial.domain.Contribuyente;

public interface ContribuyenteDAO {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public void save(Contribuyente contribuyente) throws DataAccessException;
}
