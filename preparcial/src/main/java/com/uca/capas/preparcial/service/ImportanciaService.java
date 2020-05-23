package com.uca.capas.preparcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.uca.capas.preparcial.domain.Importancia;

public interface ImportanciaService {
	public List<Importancia> findAll() throws DataAccessException;

}
