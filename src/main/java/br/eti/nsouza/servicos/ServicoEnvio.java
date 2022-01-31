package br.eti.nsouza.servicos;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.nsouza.entidades.Envio;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoEnvio {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Envio> findAll() {
		 List<Envio> env=entityManager.createQuery("from Envio").getResultList();
		 return env;
	}
	 
	 

	public Envio findOne(Integer idenvio) {
	    Envio com = entityManager.find(Envio.class, idenvio);
		return com;
	}

	@Transactional
	public Envio save(Envio cor) {
		entityManager.getTransaction().begin();
		entityManager.persist(cor);
		entityManager.getTransaction().commit();
		return cor;
    }
	@Transactional
	public void delete(Integer idenvio) {
		entityManager.getTransaction().begin();
		Envio corr = entityManager.find(Envio.class, idenvio);
		entityManager.remove(corr);
		entityManager.getTransaction().commit();
	}
	@Transactional
	public Envio update(Integer idenvio) {
		entityManager.getTransaction().begin();
		Envio corr = entityManager.find(Envio.class, idenvio);
		entityManager.merge(corr);
		entityManager.getTransaction().commit();
		return corr;
	}
	

}
