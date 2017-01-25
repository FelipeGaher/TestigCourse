package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.ComponenteDao;
import com.everis.cursotesting.modelo.Componente;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("ComponenteDao")
@Transactional(value = "transactionManager")
public class ComponenteDaoImpl extends HibernateBaseRepositoryDataSource<Componente, Long> implements ComponenteDao {

}
