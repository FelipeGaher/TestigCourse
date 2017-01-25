package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.AuditoriaDao;
import com.everis.cursotesting.modelo.Auditoria;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("AuditoriaDao")
@Transactional(value = "transactionManager")
public class AuditoriaDaoImpl extends HibernateBaseRepositoryDataSource<Auditoria, Long>implements AuditoriaDao {

}
