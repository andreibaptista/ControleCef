package br.com.controlecef.dao;

import br.com.controlecef.dao.util.GenericDao;


public interface StoredProceduresDao extends GenericDao<Object, Integer> {
	
	public boolean NOME_METODO();
	
	
}
