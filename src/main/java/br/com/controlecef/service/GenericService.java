package br.com.controlecef.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<E, ID extends Serializable> {

	public E findByPk(ID id);

	public void save(E entity);

	public void remove(E entity);
	
	public List<E> findAll();
}
