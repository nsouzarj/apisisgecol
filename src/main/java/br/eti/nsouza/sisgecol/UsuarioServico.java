package br.eti.nsouza.sisgecol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.eti.nsouza.entities.Usuario;
import br.eti.nsouza.services.ServicoUsuario;
@Component
public class UsuarioServico implements  UserDetailsService {
	@Autowired
	ServicoUsuario ser;
	@Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Usuario usuario = ser.buscanome(username);
		 if (usuario == null) {
		      throw new UsernameNotFoundException("Usuário não encontrado!");
		    }
		 
		 return (UserDetails) new Usuario(null, usuario.getNomecompleto(), usuario.getLogin(), usuario.getSenha(), username, username, username, null, null, null, false);

	  }

}
