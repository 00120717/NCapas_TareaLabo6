package com.uca.capas.preparcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.preparcial.dao.ImportanciaDAO;
import com.uca.capas.preparcial.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService{
	
	@Autowired
	ImportanciaDAO importanciaDao;
	
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDao.findAll();
	}

}
