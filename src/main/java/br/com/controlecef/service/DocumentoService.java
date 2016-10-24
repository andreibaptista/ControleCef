package br.com.controlecef.service;

import java.util.List;

import br.com.controlecef.model.Documento;

public interface DocumentoService extends GenericService<Documento, Integer> {

	public List<Documento> findInSearch(Documento documento);
	
	public boolean isRelatadedToPermissao(Integer cdDocumento);


}
