package br.com.controlecef.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.controlecef.dao.UsuarioDao;
import br.com.controlecef.exception.InactiveUsuarioException;
import br.com.controlecef.exception.InvalidUsernameOrPasswordException;
import br.com.controlecef.model.Usuario;
import br.com.controlecef.util.EncryptUtil;

@Stateless
public class AutenticacaoServiceImpl implements AutenticacaoService {

	@Inject
	private UsuarioDao usuariosDao;

	@Override
	public Usuario autenticar(String login, String senha, Integer cdMod) throws InvalidUsernameOrPasswordException,InactiveUsuarioException{
		senha = EncryptUtil.encrypt(senha);
		Usuario u = usuariosDao.autenticar(login, senha, cdMod);
		if (u == null) {
			throw new InvalidUsernameOrPasswordException();
		}
		
		return u;
	}

}
