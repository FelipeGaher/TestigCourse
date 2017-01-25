package com.everis.cursotesting.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.modelo.Aplicacion;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

/**
 * The Class IdDaoImpl.
 *
 * @author Everis
 */
@Component
@Repository("AplicacionDao")
@Transactional(value = "transactionManager")
public class AplicacionDaoImpl extends HibernateBaseRepositoryDataSource<Aplicacion, Long>implements AplicacionDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Aplicacion> getAplicaciones() {
		
		List<Aplicacion> intList = new ArrayList<Aplicacion>();
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Aplicacion.class);
		criteria.setMaxResults(10);

//		criteriaTest.add(Restrictions.eq("sTituloVentana", "NETCASH"));

		return criteria.list();

	}

//	@Override
//	public List<Aplicacion> getAplicacionesHib() {
//		// 
//				return getHibernateTemplate().execute(new HibernateCallback<List<Aplicacion>>() {
//
//					@Override
//					public List<Aplicacion> doInHibernate(Session arg0) throws HibernateException, SQLException {
//						// query
//						final String hql = "select p from Producto p ";
//						//
//						final Query query = arg0.createQuery(hql);
//						// retorno
//						final List<Aplicacion> retorno = new ArrayList<Aplicacion>();
//						// ejecuto
//						for (Object data : query.list()) {
//							retorno.add((Aplicacion) data);
//						}
//						// return
//						return retorno;
//					}
//				});
//	}

}
