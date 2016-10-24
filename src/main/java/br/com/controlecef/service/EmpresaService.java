package br.com.controlecef.service;

import java.util.List;

import br.com.controlecef.model.Empresa;

public interface EmpresaService extends GenericService<Empresa, Integer> {

	public List<Empresa> findInSearch(Empresa empresa);
	
	public boolean isRelatadedToPermissao(Integer IdEmpresa);


}
