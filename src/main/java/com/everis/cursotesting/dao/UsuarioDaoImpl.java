package com.everis.cursotesting.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everis.cursotesting.modelo.Usuario;
import com.everis.cursotesting.persistencia.HibernateBaseRepositoryDataSource;

@Component
@Repository("UsuarioDao")
@Transactional(value = "transactionManager")
public class UsuarioDaoImpl extends HibernateBaseRepositoryDataSource<Usuario, Long> implements UsuarioDao {

}
