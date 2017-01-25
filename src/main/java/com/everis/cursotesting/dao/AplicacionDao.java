package com.everis.cursotesting.dao;

import java.util.List;

import com.everis.cursotesting.modelo.Aplicacion;
import com.everis.cursotesting.persistencia.GenericPKDao;


public interface AplicacionDao extends GenericPKDao<Aplicacion, Long> {
	
	List<Aplicacion> getAplicaciones();
//	List<Aplicacion> getAplicacionesHib();
}
