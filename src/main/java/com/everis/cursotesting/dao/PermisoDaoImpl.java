package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.dao.PermisoDao;
import com.everis.cursotesting.modelo.Permiso;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("PermisoDao")
@Transactional(value = "transactionManager")
public class PermisoDaoImpl extends HibernateBaseRepositoryDataSource<Permiso, Long> implements PermisoDao {

}
