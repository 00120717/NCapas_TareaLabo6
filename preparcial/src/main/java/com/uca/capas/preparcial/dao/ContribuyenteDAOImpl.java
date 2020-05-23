package com.uca.capas.preparcial.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.preparcial.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{

	@PersistenceContext(name = "capas")
	EntityManager entityManager;
	
	//Obtener todos
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.contribuyente");
		
		Query query = entityManager.createNativeQuery(sb.toString(),Contribuyente.class);
		
		List<Contribuyente> resul = query.getResultList();
		return resul;
	}

	//Insertar
	@Override
	public void save(Contribuyente contribuyente) throws DataAccessException {
		if(contribuyente.getCcontribuyente()==null) {
			entityManager.persist(contribuyente);
		}else {
			entityManager.merge(contribuyente);
		}
	}
	
}
