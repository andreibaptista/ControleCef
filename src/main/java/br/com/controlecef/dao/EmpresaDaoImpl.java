package br.com.controlecef.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.controlecef.dao.util.GenericDaoImpl;
import br.com.controlecef.dao.util.Parametros;
import br.com.controlecef.model.Empresa;

public class EmpresaDaoImpl extends GenericDaoImpl<Empresa, Integer> implements EmpresaDao {

	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listaEmpresa() {
		Query query = em.createNamedQuery("Empresa.findAll");
		return query.getResultList();
	}

	@Override
	public boolean isRelatadedToPermissao(Integer idEmpresa) {
		return super.count("Empresa.countPermissoes", new Parametros<Integer>(
				"cdUsuario", idEmpresa)) > 0;
	}
}
