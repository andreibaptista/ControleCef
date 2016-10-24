package br.com.controlecef.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.controlecef.dao.util.GenericDaoImpl;
import br.com.controlecef.dao.util.Parametros;
import br.com.controlecef.model.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	public Usuario autenticar(String login, String senha, Integer cdMod) {
		return super.findSingleResult("Usuarios.autenticar",
								      new Parametros<String>("login", login),
								   	  new Parametros<String>("senha", senha),
									  new Parametros<Integer>("cdMod", cdMod));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaUsuario() {
		Query query = em.createNamedQuery("Usuario.findAll");
		return query.getResultList();
	}

	@Override
	public boolean isRelatadedToPermissao(Integer cdUsuario) {
		return super.count("Usuario.countPermissoes", new Parametros<Integer>(
				"cdUsuario", cdUsuario)) > 0;
	}
}
