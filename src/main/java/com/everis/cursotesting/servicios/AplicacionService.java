package com.everis.cursotesting.servicios;

import java.util.List;

import com.everis.cursotesting.modelo.Aplicacion;
import com.everis.cursotesting.modelo.Modulo;
import com.everis.cursotesting.modelo.Permiso;

public interface AplicacionService {
	
List<Aplicacion> listar();

Aplicacion obtener(Integer id);

Aplicacion nueva(Aplicacion aplicacionDTO);

Aplicacion actualizar(Aplicacion aplicacionDTO);

List<Modulo> obtenerModulos(Integer id);

List<Permiso> obtenerPermisos(Integer id);

boolean borrar(Aplicacion aplicacionDTO);

void borrarDesdeApp(Aplicacion aplicacion);

}
