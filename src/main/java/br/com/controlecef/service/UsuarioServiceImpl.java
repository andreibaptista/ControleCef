package br.com.controlecef.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.controlecef.dao.UsuarioDao;
import br.com.controlecef.dao.util.Parametros;
import br.com.controlecef.model.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioDao usuarioDao;

	@Override
	public Usuario findByPk(Integer id) {
		return usuarioDao.find(Usuario.class, id);
	}

	@Override
	public void save(Usuario usuario) {
		if (usuario != null && usuario.getCodigoUsuario() != null
				&& usuario.getCodigoUsuario() > 0) {
			usuarioDao.merge(usuario);
		} else {
			usuarioDao.save(usuario);
		}
	}

	@Override
	public void remove(Usuario usuario) {
		if (usuario != null) {
			usuarioDao.delete(usuario, usuario.getCodigoUsuario());
		}
	}

	@Override
	public List<Usuario> findInSearch(Usuario usuario) {
		return usuarioDao.findToList("",
				new Parametros<Integer>("id", usuario.getCodigoUsuario()),
				new Parametros<String>("descricao", usuario.getNomeUsuario()
						+ "%"));
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDao.listaUsuario();
	}

	@Override
	public boolean isRelatadedToPermissao(Integer cdUsuario) {
		return usuarioDao.isRelatadedToPermissao(cdUsuario);
	}

	
}
