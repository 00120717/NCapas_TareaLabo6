package com.uca.capas.preparcial.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.preparcial.dao.ContribuyenteDAO;
import com.uca.capas.preparcial.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{

	@Autowired
	ContribuyenteDAO contribuyenteDao;
	
	public List<Contribuyente> findAll() throws DataAccessException {
		
		return contribuyenteDao.findAll();
	}
	
	@Transactional
	public void save(Contribuyente c) throws DataAccessException {
		contribuyenteDao.save(c);
	}
	
}
