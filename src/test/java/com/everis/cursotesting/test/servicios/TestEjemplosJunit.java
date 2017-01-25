package com.everis.cursotesting.test.servicios;

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
public class TestEjemplosJunit extends TestContext{
	
	@Autowired
	AplicacionService aplicacionService;
	
	/**
	 * Ejemplo test sin Junit
	 */
	@Test
	public void TestApplicationObtenerBasico(){
		
		/* Parametros salida */
		Aplicacion appResponse = new Aplicacion();
		
		/* Parametros entrada */
		Integer appInput = new Integer(1);
		
	
		/* Probar servicio */
		appResponse = aplicacionService.obtener(appInput);
	
		/* Validacion */
		if(appResponse != null && appResponse.getnIdAplicacion() != null){
			
			System.out.println("INFO: RESULTADO TEST => Funciona :)");
			LOGGER.info("INFO: RESULTADO TEST => Funciona :)");
		}else {
			
			System.out.println("INFO: RESULTADO TEST => No funciona");
			LOGGER.info("INFO: RESULTADO TEST => No funciona");

		}
	}
	
	
	@Test
	public void TestAplicacionObtenerSUCCESS(){
		try {
			/* Parametros salida */
			Aplicacion appResponse = null;
			
			/* Parametros entrada */
			Integer appInput = new Integer(1);
			
		
			/* Probar servicio */
			appResponse = aplicacionService.obtener(appInput);
			
			/* Confirma que no sea nulo*/
			Assert.assertNotNull(appResponse);
			Assert.assertNotNull(appResponse.getnIdAplicacion());
			
		} catch (Exception e){
			LOGGER.info("JUNIT ERROR: " + e.getMessage());			
		}
	}
	
	@Test
	public void TestAplicacionObtenerFAIL(){
		try {
			/* Parametros salida */
			Aplicacion appResponse = new Aplicacion();
			
			/* Parametros entrada */
			Integer appInput = new Integer(1);
			
		
			/* Probar servicio */
			appResponse = aplicacionService.obtener(appInput);
			
			/* Confirma que sea nulo*/
			Assert.assertNotNull(appResponse);
			
		} catch (Exception e){
			LOGGER.info("JUNIT ERROR: " + e.getMessage());			
		}
	}
	
	@Test
	public void TestAplicacionObtenerNombreSUCCESS(){
		try {
			/* Parametros salida */
			Aplicacion appResponse = new Aplicacion();
			
			/* Parametros entrada */
			Integer appInput = new Integer(1);
			
		
			/* Probar servicio */
			appResponse = aplicacionService.obtener(appInput);
			
			/* Confirma que no sea nulo*/
			Assert.assertNotNull(appResponse);
			Assert.assertNotNull(appResponse.getnIdAplicacion());
			
			/* Confirma que el nombre sea el esperado*/
			Assert.assertEquals("LOS PARAMETROS DEBEN SER IGUALES!!", "OAO R5", appResponse.getsNombreAplicacion());
			
		} catch (Exception e){
			LOGGER.info("JUNIT ERROR: " + e.getMessage());			
		}
	}
	
	
	@Test
	public void TestAplicacionObtenerNombreFAIL(){
		try {
			/* Parametros salida */
			Aplicacion appResponse = new Aplicacion();
			
			/* Parametros entrada */
			Integer appInput = new Integer(1);
			
			/* Probar servicio */
			appResponse = aplicacionService.obtener(appInput);
			
			/* Confirma que no sea nulo*/
			Assert.assertNotNull(appResponse);
			Assert.assertNotNull(appResponse.getnIdAplicacion());
			
			/* Confirma que el nombre no sea el esperado*/
			Assert.assertNotEquals("LOS PARAMETROS NO DEBEN SER IGUALES!!", "OAO RULES", appResponse.getsNombreAplicacion());
			
		} catch (Exception e){
			LOGGER.info("JUNIT ERROR: " + e.getMessage());			
		}
	}
}
