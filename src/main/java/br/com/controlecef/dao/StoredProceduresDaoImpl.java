package br.com.controlecef.dao;

import javax.persistence.Query;

import br.com.controlecef.dao.util.GenericDaoImpl;


public class StoredProceduresDaoImpl extends GenericDaoImpl<Object, Integer> implements StoredProceduresDao {

	private static final long serialVersionUID = 1L;


	@Override
	public boolean NOME_METODO() {
					
		Query q = em.createNativeQuery("BEGIN pacote.procedure; END;");
		q.executeUpdate();		
		return true;	
		
	}
}
