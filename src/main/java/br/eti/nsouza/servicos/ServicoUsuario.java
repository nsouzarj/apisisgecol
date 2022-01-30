package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.Comarca;
import br.eti.nsouza.entidades.Usuario;

@Service
public class ServicoUsuario {
	@Autowired
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
	
	public Usuario save(Usuario usu) {
		entityManager.getTransaction().begin();
		entityManager.persist(usu);
		entityManager.getTransaction().commit();
		return usu;
    }
	public void delete(Integer idusuario) {
		entityManager.getTransaction().begin();
		Usuario usu = entityManager.find(Usuario.class, idusuario);
		entityManager.remove(usu);
		entityManager.getTransaction().commit();
	}
	public Usuario update(Integer idusuario) {
		entityManager.getTransaction().begin();
		Usuario usu = entityManager.find(Usuario.class, idusuario);
		entityManager.merge(usu);
		entityManager.getTransaction().commit();
		return usu;
	}

}
