package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.PreguntaSeguridadDao;
import com.everis.cursotesting.modelo.PreguntaSeguridad;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("PreguntaSeguridadDao")
@Transactional(value = "transactionManager")
public class PreguntaSeguridadDaoImpl extends HibernateBaseRepositoryDataSource<PreguntaSeguridad, Long> implements PreguntaSeguridadDao {

}
