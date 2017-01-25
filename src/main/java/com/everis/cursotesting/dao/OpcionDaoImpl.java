package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.OpcionDao;
import com.everis.cursotesting.modelo.Opcion;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("OpcionDao")
@Transactional(value = "transactionManager")
public class OpcionDaoImpl extends HibernateBaseRepositoryDataSource<Opcion, Long> implements OpcionDao {

}
