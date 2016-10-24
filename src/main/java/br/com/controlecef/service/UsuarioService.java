package br.com.controlecef.service;

import java.util.List;

import br.com.controlecef.model.Usuario;

public interface UsuarioService extends GenericService<Usuario, Integer> {

	public List<Usuario> findInSearch(Usuario usuario);
	
	public boolean isRelatadedToPermissao(Integer codigoUsuario);


}
