package br.com.controlecef.dao;

import java.util.List;

import br.com.controlecef.dao.util.GenericDao;
import br.com.controlecef.model.Documento;

public interface DocumentoDao extends GenericDao<Documento, Integer> {
	
	public List<Documento> listaDocumento();

	public boolean isRelatadedToPermissao(Integer cdDocumento);
}
