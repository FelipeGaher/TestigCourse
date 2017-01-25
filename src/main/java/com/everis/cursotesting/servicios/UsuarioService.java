package com.everis.cursotesting.servicios;

import java.util.List;

import com.everis.cursotesting.modelo.Permiso;
import com.everis.cursotesting.modelo.PreguntaSeguridad;
import com.everis.cursotesting.modelo.Usuario;

public interface UsuarioService {
	
	public Usuario obtenerPorNombre(String nombreUsuario);
	public List<Permiso> obtenerPermisos(Integer idUsuario);
	public List<PreguntaSeguridad> obtenerPreguntasSeguridad(Integer idUsuario);

}
