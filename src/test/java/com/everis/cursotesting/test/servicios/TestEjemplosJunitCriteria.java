package com.everis.cursotesting.test.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.cursotesting.modelo.Aplicacion;
import com.everis.cursotesting.servicios.AplicacionService;
import com.everis.cursotesting.test.contexto.TestContext;
/**
 * 
 * @author fgajardo
 *
 */
public class TestEjemplosJunitCriteria extends TestContext{
	
	@Autowired
	AplicacionService aplicacionService;
	
	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;
	
	@Test
	public void TestAplicacionObtenerSUCCESS(){
		try {
			/* Parametros salida */
			Aplicacion appResponse = new Aplicacion();
			
			/* Parametros entrada */
			Integer appInput = new Integer(1);
			
			List <Aplicacion> intList = new ArrayList<Aplicacion>();
			
			
			Session session = sessionFactory.getCurrentSession();
			Criteria criteriaTest = session.createCriteria(Aplicacion.class);
			criteriaTest.setMaxResults(1);
			
			criteriaTest.add(Restrictions.eq("sTituloVentana", "NETCASH"));	
			
				
			intList = criteriaTest.list();
			if(!intList.isEmpty()){
				appInput = intList.get(0).getnIdAplicacion().intValue();
			}

			/* Probar servicio */
			appResponse = aplicacionService.obtener(appInput);
			
			/* Confirma que no sea nulo*/
			Assert.assertNotNull(appResponse);
			Assert.assertNotNull(appResponse.getnIdAplicacion());
			
		} catch (Exception e){
			LOGGER.info("EXCEPTION: " + e.getMessage());			
		}
	}
}
