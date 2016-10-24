package br.com.controlecef.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.controlecef.dao.StoredProceduresDao;


@Stateless
public class StoredProceduresServiceImpl implements StoredProceduresService {

	@Inject
	private StoredProceduresDao spDao;

	@Override
	public boolean NOME_METODO() throws Exception {		
		try {			
			spDao.NOME_METODO();	
			return true;		
		} catch (PersistenceException e) {
			throw new Exception(e);
		}
	}
}
