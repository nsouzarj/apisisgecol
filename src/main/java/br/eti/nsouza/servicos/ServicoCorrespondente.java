package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.Correspondente;

@Service
public class ServicoCorrespondente {
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Correspondente> findAll() {
		List<Correspondente> corr=entityManager.createQuery("from Correspondente order by nome").getResultList();
		  return corr;
		}

	public Correspondente findOne(Integer idcorrespondente) {
		Correspondente com = entityManager.find(Correspondente.class, idcorrespondente);
		return com;

	}

	public Correspondente save(Correspondente cor) {
		entityManager.getTransaction().begin();
		entityManager.persist(cor);
		entityManager.getTransaction().commit();
		return cor;
	}

	public void delete(Integer idcorrespondente) {
		entityManager.getTransaction().begin();
		Correspondente corr = entityManager.find(Correspondente.class, idcorrespondente);
		entityManager.remove(corr);
		entityManager.getTransaction().commit();
	}

	public Correspondente update(Integer idcorrespondente) {
		entityManager.getTransaction().begin();
		Correspondente corr = entityManager.find(Correspondente.class, idcorrespondente);
		entityManager.merge(corr);
		entityManager.getTransaction().commit();
		return corr;
	}

}
