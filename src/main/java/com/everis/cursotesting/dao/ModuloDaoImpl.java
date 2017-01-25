package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.ModuloDao;
import com.everis.cursotesting.modelo.Modulo;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("ModuloDao")
@Transactional(value = "transactionManager")
public class ModuloDaoImpl extends HibernateBaseRepositoryDataSource<Modulo, Long> implements ModuloDao {

}
