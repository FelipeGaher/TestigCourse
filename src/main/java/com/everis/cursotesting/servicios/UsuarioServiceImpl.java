package com.everis.cursotesting.servicios;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.UsuarioDao;
import com.everis.cursotesting.modelo.Permiso;
import com.everis.cursotesting.modelo.PreguntaSeguridad;
import com.everis.cursotesting.modelo.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl  implements UsuarioService {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	Mapper mapper;

	public Usuario obtenerPorNombre(String nombreUsuario) {
		Usuario usuario = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteriaTest = session.createCriteria(Usuario.class);
		criteriaTest.setMaxResults(1);
		criteriaTest.add(Restrictions.eq("sNombreUsuario", nombreUsuario));
		@SuppressWarnings("unchecked")
		List<Usuario> list= criteriaTest.list();
		if(!list.isEmpty()){
			Usuario u = list.get(0);
			usuario = mapper.map(u, Usuario.class);
		}
		return usuario;
	
	}

	public List<Permiso> obtenerPermisos(Integer idUsuario) {
		Usuario u = usuarioDao.get(idUsuario.longValue());
		List<Permiso>  lPermiso = new ArrayList<Permiso>();
		for(Permiso p : u.getPermisos()){
			lPermiso.add(mapper.map(p, Permiso.class));
		}
		return lPermiso;
	}

	public List<PreguntaSeguridad> obtenerPreguntasSeguridad(Integer idUsuario) {
		Usuario u = usuarioDao.get(idUsuario.longValue());
		List<PreguntaSeguridad>  lPreSegur = new ArrayList<PreguntaSeguridad>();
		for(PreguntaSeguridad p : u.getPreguntaSeguridads()){
			lPreSegur.add(mapper.map(p, PreguntaSeguridad.class));
		}
		return lPreSegur;
	}

}
