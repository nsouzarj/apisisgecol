package br.eti.nsouza.servicos;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.eti.nsouza.entidades.Uf;

@Service
public class ServicoUf {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Uf> findAll() {
        
		List<Uf>  uf = entityManager.createQuery("from Uf order by nome").getResultList();
		return uf;
	}

	public Uf findOne(Integer iduf) {
	    Uf uf =entityManager.find(Uf.class, iduf);
		return uf;
		
	}
	@Transactional
	public Uf save(Uf uf) {
		entityManager.getTransaction().begin();
		entityManager.persist(uf);
		entityManager.getTransaction().commit();
		return uf;
    }
	@Transactional
	public void delete(Integer iduf) {
		entityManager.getTransaction().begin();
		Uf uf = entityManager.find(Uf.class, iduf);
		entityManager.remove(uf);
		entityManager.getTransaction().commit();
	}
	@Transactional
	public Uf update(Integer iduf) {
		entityManager.getTransaction().begin();
		Uf uf = entityManager.find(Uf.class, iduf);
		entityManager.merge(uf);
		entityManager.getTransaction().commit();
		return uf;
	}
	 

}
