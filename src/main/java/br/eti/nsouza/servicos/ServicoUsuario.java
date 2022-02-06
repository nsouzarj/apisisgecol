package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.Comarca;
import br.eti.nsouza.entidades.Usuario;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoUsuario {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		List<Usuario>  usu= entityManager.createQuery("from Usuario where login is not null"
		   		+ "  and ativo=true and tipo in (1,2) order by nomecompleto").getResultList();
		   return usu;
		}

	public Usuario findOne(Integer idusuario) {
	    Usuario usu =entityManager.find(Usuario.class, idusuario);
		return usu;
		
	}
	
	public Usuario buscanome(String emailprincipal) {
	    Usuario usu =(Usuario) entityManager.createQuery("from Usuario where emailprincipal="+emailprincipal+"").getSingleResult();
	    System.out.printf("usuario "+usu);
		return usu;
		
	}
	@Transactional
	public Usuario save(Usuario usu) {
	    entityManager.persist(usu);
		return usu;
    }
	@Transactional
	public void delete(Integer idusuario) {
		Usuario usu = entityManager.find(Usuario.class, idusuario);
		entityManager.remove(usu);
	}
	@Transactional
	public Usuario update(Integer idusuario) {
		Usuario usu = entityManager.find(Usuario.class, idusuario);
		entityManager.merge(usu);
		return usu;
	}

}
