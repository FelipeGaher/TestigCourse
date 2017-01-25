package com.everis.cursotesting.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.everis.cursotesting.dao.AplicacionDao;
import com.everis.cursotesting.modelo.Aplicacion;
/**
 * 
 * @author fgajardo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = "classpath:context/Model-context.xml")
public class TestAplicacionDAOhsql {

	// inyectamos el dao a probar
	@Autowired
	AplicacionDao dao;
	// conexion bbdd
	@Autowired
	JdbcTemplate jdbc;
	
	@Before
	public void before() {
		jdbc.execute("delete from aplicacion");
		jdbc.execute("insert into aplicacion (N_ID_APLICACION, B_ACTIVO, S_NOMBRE_APLICACION,"
				+ "S_TITULO_VENTANA, S_URL_INICIO, S_VERSION_APLICACION) "
				+ "values (100, 2, 'Hola', 'Titulo', 'http', 'OAO')");
		jdbc.execute("insert into aplicacion (N_ID_APLICACION, B_ACTIVO, S_NOMBRE_APLICACION,"
				+ "S_TITULO_VENTANA, S_URL_INICIO, S_VERSION_APLICACION) "
				+ "values (200, 3, 'Chao', 'Titulo', 'http', 'OAO')");
//		jdbc.execute("insert into producto (id_producto, nombre_producto, id_tipo) values (2, 'producto2', 1)");
	}
	
	@Test
	public void testHsql() {
		
		List<Aplicacion> applicaciones = dao.getAplicaciones();
		
		Assert.assertNotNull(applicaciones);
		Assert.assertEquals(2, applicaciones.size());
	}
}
