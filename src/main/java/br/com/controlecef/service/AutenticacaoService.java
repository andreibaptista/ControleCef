package br.com.controlecef.service;

import javax.ejb.Local;

import br.com.controlecef.exception.InactiveUsuarioException;
import br.com.controlecef.exception.InvalidUsernameOrPasswordException;
import br.com.controlecef.model.Usuario;

@Local
public interface AutenticacaoService {
	
	Usuario autenticar(String login, String senha, Integer cdMod) throws InvalidUsernameOrPasswordException,InactiveUsuarioException;
}
