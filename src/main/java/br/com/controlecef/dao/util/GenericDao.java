package br.com.controlecef.dao.util;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, E extends Serializable> {

	public T merge(T entidade);

	public void delete(T entidade, E chave);

	public T find(Class<T> clazz, E chave);
	
	public List<T> findToList(String namedQuery, Parametros<?>... parametros);

	public T findSingleResult(String namedQuery, Parametros<?>... parametros);

	public Long count(String namedQuery, Parametros<?>... parametros);

	public void save(T t);
}
