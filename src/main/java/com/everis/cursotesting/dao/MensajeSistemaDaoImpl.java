package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.MensajeSistemaDao;
import com.everis.cursotesting.modelo.MensajeSistema;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("MensajeSistemaDao")
@Transactional(value = "transactionManager")
public class MensajeSistemaDaoImpl extends HibernateBaseRepositoryDataSource<MensajeSistema, Long> implements MensajeSistemaDao {

}
