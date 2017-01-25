package com.everis.cursotesting.services.test;

import org.junit.Assert;
import org.junit.Ignore;
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
public class AplicacionServiceTest extends TestContext{

	@Autowired
	AplicacionService appService;
	
	@Test
	public void test01(){
		
		Aplicacion output = new Aplicacion();
		Integer input = new Integer(2);
		
		//Ejecuta servicio
		output = appService.obtener(input);
		
		Assert.assertNotNull(output);
	
	}
	
	@Test
	public void test02(){
		
		Aplicacion output = new Aplicacion();
		Integer input = new Integer(44);
		
		//Ejecuta servicio
		output = appService.obtener(input);
		
		Assert.assertNull(output);
		Assert.assertEquals("OAO", output.getsTituloVentana());
	
	}
	
	@Test
	public void test03(){
		
		Aplicacion output = new Aplicacion();
		Integer input = new Integer(2);
		
		//Ejecuta servicio
		output = appService.obtener(input);
		
		Assert.assertNotNull(output);
		Assert.assertEquals("OAO", output.getsTituloVentana());

	}
}
