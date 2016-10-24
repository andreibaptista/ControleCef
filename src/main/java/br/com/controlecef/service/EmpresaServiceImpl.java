package br.com.controlecef.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.controlecef.dao.EmpresaDao;
import br.com.controlecef.dao.util.Parametros;
import br.com.controlecef.model.Empresa;

@Stateless
public class EmpresaServiceImpl implements EmpresaService {

	@Inject
	private EmpresaDao empresaDao;

	@Override
	public Empresa findByPk(Integer id) {
		return empresaDao.find(Empresa.class, id);
	}

	@Override
	public void save(Empresa empresa) {
		if (empresa != null && empresa.getIdEmpresa() != null
				&& empresa.getIdEmpresa() > 0) {
			empresaDao.merge(empresa);
		} else {
			empresaDao.save(empresa);
		}
	}

	@Override
	public void remove(Empresa empresa) {
		if (empresa != null) {
			empresaDao.delete(empresa, empresa.getIdEmpresa());
		}
	}

	@Override
	public List<Empresa> findInSearch(Empresa empresa) {
		return empresaDao.findToList("",
				new Parametros<Integer>("id", empresa.getIdEmpresa()),
				new Parametros<String>("descricao", empresa.getNome()
						+ "%"));
	}

	@Override
	public List<Empresa> findAll() {
		return empresaDao.listaEmpresa();
	}

	@Override
	public boolean isRelatadedToPermissao(Integer cdEmpresa) {
		return empresaDao.isRelatadedToPermissao(cdEmpresa);
	}

	
}
