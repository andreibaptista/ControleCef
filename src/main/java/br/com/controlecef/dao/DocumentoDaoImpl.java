package br.com.controlecef.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.controlecef.dao.util.GenericDaoImpl;
import br.com.controlecef.dao.util.Parametros;
import br.com.controlecef.model.Documento;

public class DocumentoDaoImpl extends GenericDaoImpl<Documento, Integer> implements DocumentoDao {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listaDocumento() {
		Query query = em.createNamedQuery("Documento.findAll");
		return query.getResultList();
	}

	@Override
	public boolean isRelatadedToPermissao(Integer cdDocumento) {
		return super.count("Documento.countPermissoes", new Parametros<Integer>(
				"cdDocumento", cdDocumento)) > 0;
	}

}
