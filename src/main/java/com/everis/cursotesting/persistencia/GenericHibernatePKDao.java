package com.everis.cursotesting.persistencia;

import java.io.Serializable;
/**
 * 
 * @author
 *
 * @param <T> TYPE.
 * @param <ID> ID.
 */
public class GenericHibernatePKDao<T extends Serializable, ID extends Serializable> extends AbstractHibernatePKDao<T, ID> {
	
}
