package com.uca.capas.preparcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.preparcial.domain.Contribuyente;

public interface ContribuyenteService {
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public void save(Contribuyente c) throws DataAccessException;
}
