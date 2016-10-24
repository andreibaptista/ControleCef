package br.com.controlecef.dao.util;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
public class GenericDaoImpl<T, E extends Serializable> implements Serializable,GenericDao<T, E> {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "SegurancaPU")
	protected EntityManager em;

	public T merge(T entidade) {
		em.merge(entidade);
		return entidade;
	}

	@SuppressWarnings("unchecked")
	public void delete(T entidade, E chave) {
		entidade = (T) em.getReference(entidade.getClass(), chave);
		em.remove(entidade);
	}

	public T find(Class<T> clazz, E chave) {
		return em.find(clazz, chave);
	}

	@SuppressWarnings("unchecked")
	public T findClass(T entidade, E entidadeComposta) {
		return (T) em.find(entidade.getClass(), entidadeComposta.getClass());
	}

	public void save(T t) {
		em.persist(t);
		em.flush();
		em.refresh(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> findToList(String namedQuery, Parametros<?>... parametros) {
		Query query = em.createNamedQuery(namedQuery);
		if (parametros != null) {
			for (Parametros<?> item : parametros) {
				if (item != null)
					query.setParameter(item.getNome(), item.getValor());
			}
		}
		try {
			return query.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public T findSingleResult(String namedQuery, Parametros<?>... parametros) {
		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null) {
				for (Parametros<?> item : parametros) {
					query.setParameter(item.getNome(), item.getValor());
				}
			}
			return (T) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Long count(String namedQuery, Parametros<?>... parametros) {
		Query query = em.createNamedQuery(namedQuery);
		if (parametros != null) {
			for (Parametros<?> item : parametros) {
				query.setParameter(item.getNome(), item.getValor());
			}
		}
		return (Long) query.getSingleResult();
	}

}
