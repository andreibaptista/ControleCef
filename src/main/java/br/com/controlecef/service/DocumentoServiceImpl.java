package br.com.controlecef.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.controlecef.dao.DocumentoDao;
import br.com.controlecef.dao.util.Parametros;
import br.com.controlecef.model.Documento;

@Stateless
public class DocumentoServiceImpl implements DocumentoService {

	@Inject
	private DocumentoDao documentoDao;

	@Override
	public Documento findByPk(Integer id) {
		return documentoDao.find(Documento.class, id);
	}

	@Override
	public void save(Documento documento) {
		if (documento != null && documento.getIddocumento() != null
				&& documento.getIddocumento() > 0) {
			documentoDao.merge(documento);
		} else {
			documentoDao.save(documento);
		}
	}

	@Override
	public void remove(Documento documento) {
		if (documento != null) {
			documentoDao.delete(documento, documento.getIddocumento());
		}
	}

	@Override
	public List<Documento> findInSearch(Documento documento) {
		return documentoDao.findToList("",
				new Parametros<Integer>("id", documento.getIddocumento()),
				new Parametros<String>("tipoAcompanhamento", documento.getTipoAcompanhamento()
						+ "%"));
	}

	@Override
	public List<Documento> findAll() {
		return documentoDao.listaDocumento();
	}

	@Override
	public boolean isRelatadedToPermissao(Integer cdDocumento) {
		return documentoDao.isRelatadedToPermissao(cdDocumento);
	}
}
