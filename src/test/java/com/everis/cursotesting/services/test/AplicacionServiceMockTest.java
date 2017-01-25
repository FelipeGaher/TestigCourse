package com.everis.cursotesting.services.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.cursotesting.dao.AplicacionDao;
import com.everis.cursotesting.modelo.Aplicacion;
import com.everis.cursotesting.servicios.AplicacionService;
import com.everis.cursotesting.servicios.AplicacionServiceImpl;
import com.everis.cursotesting.servicios.UsuarioService;
import com.everis.cursotesting.test.contexto.TestContext;

/**
 * 
 * @author fgajardo
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AplicacionServiceMockTest extends TestContext {

	@InjectMocks
	@Autowired
	AplicacionService appService = new AplicacionServiceImpl();

	@Mock
	AplicacionDao applicacionDao;
	
	@Mock
	UsuarioService usario;

	Aplicacion aplicacion;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		aplicacion = new Aplicacion();
		aplicacion.setnIdAplicacion(3l);
		aplicacion.setsNombreAplicacion("CURSOTESTING");
		aplicacion.setsTituloVentana("OAO");

	}

	@Test
	public void test01() {

		Aplicacion output = new Aplicacion();
		Integer input = new Integer(2);

		// Stub
		// Cuando aplicacionDAO haga un get(), entonces retorna el objeto
		// "aplicacion"
		Mockito.when(applicacionDao.get(Mockito.anyLong())).thenReturn(aplicacion);
//		Mockito.when(usario.obtenerPermisos(Mockito.anyInt())).thenReturn(null);

		
		// Ejecuta servicio
		output = appService.obtener(input);

		// verifca aplicacionDao utilizo el metodo get 1 vez
		verify(applicacionDao, times(1)).get(Mockito.anyLong());

		Assert.assertNotNull(output);

	}

	@Test
	public void test02() {

		Aplicacion output = new Aplicacion();

		// Stub
		Mockito.doThrow(new HibernateException("ERROR GENERADO POR MOCKITO")).
			when(applicacionDao).delete(Mockito.any(Aplicacion.class));
	
		// Ejecuta servicio
		appService.borrarDesdeApp(new Aplicacion());

		// verifca aplicacionDao utilizo el metodo get 1 vez
		verify(applicacionDao, times(1)).delete(Mockito.any(Aplicacion.class));

		Assert.assertNotNull(output);

	}
}
