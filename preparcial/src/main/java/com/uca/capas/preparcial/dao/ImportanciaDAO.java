package com.uca.capas.preparcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.capas.preparcial.domain.Importancia;

public interface ImportanciaDAO {
	public List<Importancia> findAll() throws DataAccessException;
	
	//public Importancia findOne(Integer c_importancia) throws DataAccessException;
}
