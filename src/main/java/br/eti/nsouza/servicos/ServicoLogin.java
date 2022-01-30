package br.eti.nsouza.servicos;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.EjbAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.Usuario;

@Service
public class ServicoLogin {

	@Autowired
	private EntityManager entityManager;

	public Usuario busca(String emaiprincipal, String senha) {
		

        try {
        	Usuario novo=null;
    		Usuario usu = (Usuario) entityManager.createQuery("from Usuario where emailprincipal=" + "'" + emaiprincipal.toString() + "'").getSingleResult();

    		boolean valido = new BCryptPasswordEncoder().matches(senha, usu.getSenha());

    		if (valido == true) {
                novo=usu;
    			System.out.println("Anchou"); 
    		}else {
    			System.out.println("Não achou"); 
    			novo=null;
    		}
            return novo;
    	
		} catch (EjbAccessException e) {
			System.out.print("erro"+e);
		}
		return null;
	}
}
