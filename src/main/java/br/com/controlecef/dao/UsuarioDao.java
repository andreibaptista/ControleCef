package br.com.controlecef.dao;


import java.util.List;

import br.com.controlecef.dao.util.GenericDao;
import br.com.controlecef.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {
	
	public List<Usuario> listaUsuario();
	
	Usuario autenticar(String login, String senha,Integer cdMod);
	
	public boolean isRelatadedToPermissao(Integer cdUsuario);
}
