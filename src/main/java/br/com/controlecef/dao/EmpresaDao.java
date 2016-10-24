package br.com.controlecef.dao;


import java.util.List;

import br.com.controlecef.dao.util.GenericDao;
import br.com.controlecef.model.Empresa;

public interface EmpresaDao extends GenericDao<Empresa, Integer> {
	
	public List<Empresa> listaEmpresa();
	
	public boolean isRelatadedToPermissao(Integer idEmpresa);

	
}
