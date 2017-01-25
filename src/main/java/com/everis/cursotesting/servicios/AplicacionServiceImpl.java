package com.everis.cursotesting.servicios;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.AplicacionDao;
import com.everis.cursotesting.modelo.Aplicacion;
import com.everis.cursotesting.modelo.Modulo;
import com.everis.cursotesting.modelo.Permiso;

@Service
@Transactional
public class AplicacionServiceImpl implements AplicacionService {

	@Autowired
	AplicacionDao applicacionDao;
	@Autowired
	Mapper mapper;

	@Autowired
	UsuarioService usario;

	@Autowired
	UsuarioService userService;

	public List<Aplicacion> listar() {
		List<Aplicacion> list = new ArrayList<Aplicacion>();
		for (Aplicacion aplicacion : applicacionDao.findAll()) {
			list.add(mapper.map(aplicacion, Aplicacion.class));
		}
		return list;
	}
/**
 * SERVICIO OBTENER
 */
	public Aplicacion obtener(Integer id) {
		Aplicacion aplicacion = applicacionDao.get(id.longValue());

//		// Servicio
//		usario.obtenerPermisos(new Integer(1));
//		List<Permiso> list = new ArrayList<Permiso>();
//
//		if (list.isEmpty()) {
//			// AASDASD
//		} else {
//			// ASDASDASD
//		}
		Aplicacion appDTO = null;
		if (aplicacion != null) {
			appDTO = new Aplicacion();

			if (aplicacion != null) {
				if (aplicacion.getbActivo() != null) {
					appDTO.setbActivo(aplicacion.getbActivo());
				}
				if (aplicacion.getnIdAplicacion() != null) {
					appDTO.setnIdAplicacion(aplicacion.getnIdAplicacion());
				}
				if (aplicacion.getsNombreAplicacion() != null) {
					appDTO.setsNombreAplicacion(aplicacion.getsNombreAplicacion());
				}
				if (aplicacion.getsTituloVentana() != null) {
					appDTO.setsTituloVentana(aplicacion.getsTituloVentana());
				}
				if (aplicacion.getsUrlInicio() != null) {
					appDTO.setsUrlInicio(aplicacion.getsUrlInicio());
				}
				if (aplicacion.getsVersionAplicacion() != null) {
					appDTO.setsVersionAplicacion(aplicacion.getsVersionAplicacion());
				}
			}
		}
		return appDTO;
	}

	public Aplicacion nueva(Aplicacion aplicacionDTO) {
		Aplicacion aplicacion = applicacionDao.save(mapper.map(aplicacionDTO, Aplicacion.class));
		Aplicacion appDTO = new Aplicacion();
		appDTO = mapper.map(aplicacion, Aplicacion.class);
		return appDTO;
	}

	public Aplicacion actualizar(Aplicacion aplicacionDTO) {
		Aplicacion aplicacion = applicacionDao.update(mapper.map(aplicacionDTO, Aplicacion.class));
		return mapper.map(aplicacion, Aplicacion.class);
	}

	public boolean borrar(Aplicacion aplicacionDTO) {
		Aplicacion app = null;

		if (aplicacionDTO != null) {

			app = new Aplicacion();

			if (aplicacionDTO.getbActivo() != null) {
				app.setbActivo(aplicacionDTO.getbActivo());
			}
			if (aplicacionDTO.getnIdAplicacion() != null) {
				app.setnIdAplicacion(aplicacionDTO.getnIdAplicacion().longValue());
			}
			if (aplicacionDTO.getsNombreAplicacion() != null) {
				app.setsNombreAplicacion(aplicacionDTO.getsNombreAplicacion());
			}
			if (aplicacionDTO.getsTituloVentana() != null) {
				app.setsTituloVentana(aplicacionDTO.getsTituloVentana());
			}
			if (aplicacionDTO.getsUrlInicio() != null) {
				app.setsUrlInicio(aplicacionDTO.getsUrlInicio());
			}
			if (aplicacionDTO.getsVersionAplicacion() != null) {
				app.setsVersionAplicacion(aplicacionDTO.getsVersionAplicacion());
			}
		}

		applicacionDao.delete(app);
		return true;
	}

	public void borrarDesdeApp(Aplicacion aplicacion) {
		try {
			applicacionDao.delete(aplicacion);
	
		} catch (Exception e) {
			System.out.println("HOLA, ME CAÍ --" + e.getMessage());
			System.out.println("HOLA, ME CAÍ --" + e.getMessage());
			System.out.println("HOLA, ME CAÍ --" + e.getMessage());
			System.out.println("HOLA, ME CAÍ --" + e.getMessage());
			System.out.println("HOLA, ME CAÍ --" + e.getMessage());
			System.out.println("HOLA, ME CAÍ --" + e.getMessage());

			/**
			 * SAD asd as d AS Da sD as d asD as fa sd sa d
			 * 
			 */
		}
	}

	public List<Modulo> obtenerModulos(Integer id) {
		List<Modulo> list = new ArrayList<Modulo>();
		Aplicacion aplicacion = applicacionDao.get(id.longValue());
		for (Modulo modulo : aplicacion.getModulos()) {
			list.add(mapper.map(modulo, Modulo.class));
		}
		return list;
	}

	public List<Permiso> obtenerPermisos(Integer id) {
		List<Permiso> list = new ArrayList<Permiso>();
		Aplicacion aplicacion = applicacionDao.get(id.longValue());
		for (Permiso permiso : aplicacion.getPermisos()) {
			list.add(mapper.map(permiso, Permiso.class));
		}
		return list;
	}

}
