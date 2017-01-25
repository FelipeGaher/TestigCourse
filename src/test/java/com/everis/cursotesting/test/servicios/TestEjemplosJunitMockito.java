package com.everis.cursotesting.test.servicios;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.dozer.Mapper;
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
import com.everis.cursotesting.modelo.Usuario;
import com.everis.cursotesting.servicios.AplicacionService;
import com.everis.cursotesting.servicios.AplicacionServiceImpl;
import com.everis.cursotesting.test.contexto.TestContext;

/**
 * 
 * @author fgajardo
 *
 */
/* Inicializa las anotaciones @Mock*/
@RunWith(MockitoJUnitRunner.class)
public class TestEjemplosJunitMockito extends TestContext {

	@InjectMocks
	@Autowired
	AplicacionService aplicacionService = new AplicacionServiceImpl();

	@Mock
	AplicacionDao applicacionDao;

	@Mock
	Mapper mapper;
	
	@Mock
	Usuario user;

	/* obj para before */
	Aplicacion aplicacion;
	Aplicacion appDTO;

	@Before
	public void preparacion() {
		MockitoAnnotations.initMocks(this);

		aplicacion = new Aplicacion();
		aplicacion.setsNombreAplicacion("OAO RULES");
		aplicacion.setsVersionAplicacion("R5");
		aplicacion.setsTituloVentana("Titulo");

	}

	@Test
	public void TestAplicacionObtenerSUCCESS() {
		try {
			/* Parametros salida */
			Aplicacion appResponse = new Aplicacion();

			/* Parametros entrada */
			Integer appInput = new Integer(1);

			/* Stub */
			Mockito.when(applicacionDao.get(appInput.longValue())).thenReturn(aplicacion);

			/* Probar servicio */
			appResponse = aplicacionService.obtener(appInput);

			/* Verificamos las invocaciones */
			verify(applicacionDao, times(1)).get(Mockito.anyLong());

			/* Confirma que no sea nulo */
			Assert.assertNotNull(appResponse);

		} catch (Exception e) {
			LOGGER.info("JUNIT ERROR: " + e.getMessage());
		}
	}

	@Test
	public void TestAplicacionBorrarMock() {
		try {
			/* Parametros entrada */
			Aplicacion appDTO = new Aplicacion();

			appDTO.setsNombreAplicacion("OAO RULES RETORNO");
			appDTO.setsVersionAplicacion("R5 RETORNO");
			appDTO.setsTituloVentana("Titulo RETORNO");

			/* Parametros salida */
			boolean response = false;

			/* Stub */
			doNothing().when(applicacionDao).delete(aplicacion);
			
			/* Probar servicio */
			aplicacionService.borrarDesdeApp(aplicacion);

			/* Verificamos las invocaciones */
			verify(applicacionDao, times(1)).delete(aplicacion);


		} catch (Exception e) {
			LOGGER.info("JUNIT ERROR: " + e.getMessage());
		}
	}

	@Test
	public void TestAplicacionBorrarMockEXCEPTION() {
		try {
			/* Parametros entrada */
			Aplicacion appDTO = new Aplicacion();

			appDTO.setsNombreAplicacion("OAO RULES RETORNO");
			appDTO.setsVersionAplicacion("R5 RETORNO");
			appDTO.setsTituloVentana("Titulo RETORNO");

			/* Parametros salida */
			boolean response = false;

			/* Stub */			
			doThrow(new HibernateException("ERROR CREADO POR MOCK!!!!")).when(applicacionDao).delete(aplicacion);

			/* Probar servicio */
			aplicacionService.borrarDesdeApp(aplicacion);

			/* Verificamos las invocaciones */
			verify(applicacionDao, times(1)).delete(aplicacion);


		} catch (Exception e) {
			/* Verificamos las invocaciones */
			verify(applicacionDao, times(1)).delete(aplicacion);
			LOGGER.info("JUNIT ERROR: " + e.getMessage());
		}
	}
}
