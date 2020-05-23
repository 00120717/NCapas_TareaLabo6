package com.uca.capas.preparcial.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.preparcial.domain.Contribuyente;
import com.uca.capas.preparcial.domain.Importancia;
import com.uca.capas.preparcial.service.ContribuyenteService;
import com.uca.capas.preparcial.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	ContribuyenteService contribuyenteService;
	
	@Autowired
	ImportanciaService ImportanciaService;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();	
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> importancias= null;
		
		try {
			importancias = ImportanciaService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		mav.addObject("importancias",importancias);
		mav.addObject("contribuyente",contribuyente);
		mav.setViewName("index");
		
		return mav;
		
	}
	
	@RequestMapping("/save")
	public ModelAndView saveContribuyente(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		 ModelAndView mav  = new ModelAndView();
		 List<Importancia> importancias= null;
		 
		 if(result.hasErrors()) {
	    		
	    		try{
	    			importancias = ImportanciaService.findAll();
	    		}
	    		catch (Exception e) {
	    			// TODO: handle exception
	    			e.printStackTrace();
	    		}
	    		
	    		mav.addObject("importancias",importancias);
	            mav.setViewName("index");
	            System.out.println("if - has errors");
	        }
	        else{
	        	System.out.println("else");
	    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    		
	    		long millis=System.currentTimeMillis();  
	            Date date=new java.sql.Date(millis);
	        	System.out.println("importancia"+contribuyente.getImportancia());
	    		
	        	contribuyente.setFfechaingreso(date);
	            contribuyenteService.save(contribuyente);
	            
	            //Limpiar input
	            Contribuyente contribuyent = new Contribuyente();
	            try{
	    			importancias = ImportanciaService.findAll();
	    		}
	    		catch (Exception e) {
	    			// TODO: handle exception
	    			e.printStackTrace();
	    		}
	    		
	    		mav.addObject("importancias",importancias);
	            mav.addObject("contribuyente", contribuyent);
	            mav.setViewName("index");
	        }
	       
	        return mav;
	}
	
	@RequestMapping("/contribuyentes")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes= null;
		
		try {
			contribuyentes = contribuyenteService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("contribuyentes",contribuyentes);
		mav.setViewName("contribuyentes");
		
		return mav;
	}
	
}
