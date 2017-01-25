package com.everis.cursotesting.test.servicios;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.cursotesting.modelo.Aplicacion;
import com.everis.cursotesting.servicios.AplicacionService;
import com.everis.cursotesting.test.contexto.TestContext;

/**
 * 
 * @author fgajardo
 *
 */
public class TestEjemplosJunitExceptions extends TestContext{
	
	@Autowired
	AplicacionService aplicacionService;
	
	/**
	 * try-catch idiom way
	 */	
	@Test
	public void testExceptionMessage01() {
	    try {
	        new ArrayList<Object>().get(0);
	        fail("Se espera que se lanze un IndexOutOfBoundsException");
	    } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	        Assert.assertEquals(anIndexOutOfBoundsException.getMessage(), ("Index: 0, Size: 0"));
	    }
	}
	
	/* Anotacion rule para probar excepciones especificas en los tests*/
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * With JUnit rule
	 */
	@Test
	public void TestJunitRule02() throws IndexOutOfBoundsException {
	    List<Object> list = new ArrayList<Object>();

		/* Se agrega la excepcion a esperar*/
	    thrown.expect(IndexOutOfBoundsException.class);
	    	    
	    /* Se ejecuta el metodo*/
	    list.get(0); 
	}
	
	@Test
 	public void throwsNullPointerException() {
		  thrown.expect(IndexOutOfBoundsException.class);
 		throw new NullPointerException();
     }

	
	/**
	 * With annotation
	 */
	@Test(expected = NullPointerException.class)
	public void TestAplicacionObtener03(){
		
		/* Parametros salida */
		Aplicacion appResponse = new Aplicacion();
		
		/* Parametros entrada (Se sabe que dará error al ser null)*/
		Integer appInput = null;
		
		/* Probar servicio */
		appResponse = aplicacionService.obtener(appInput);
	}
	
	/**
	 * Withouut annotation - fails
	 */
	@Test
	public void testExceptionMessage03() {
	 
		new ArrayList<Object>().get(0);
	    
	}
	
	/**
	 * With annotation
	 */
	@Test(expected = IndexOutOfBoundsException.class)  
	public void testExceptionMessage04() {
	 
		new ArrayList<Object>().get(0);
	    
	}
	
	/**
	 * With wrong annotation - fails
	 */
	@Test(expected = NullPointerException.class)  
	public void testExceptionMessage05() {
	 
		new ArrayList<Object>().get(0);
	    
	}
	
	/**
	 * With wrong annotation - success
	 */
	@Test(expected = Exception.class)  
	public void testExceptionMessage06() {
	 
		new ArrayList<Object>().get(0);
	    
	}
}
