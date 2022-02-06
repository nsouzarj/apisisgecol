package br.eti.nsouza.servicos;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.Correspondente;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoCorrespondente {
	@PersistenceContext
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
	@Transactional
	public Correspondente save(Correspondente cor) throws SQLException {
		entityManager.persist(cor);
		return cor;
	}
	@Transactional
	public void delete(Integer idcorrespondente) {
		Correspondente corr = entityManager.find(Correspondente.class, idcorrespondente);
		entityManager.remove(corr);

	}

	@Transactional
	public Correspondente update(Integer idcorrespondente) {
		Correspondente corr = entityManager.find(Correspondente.class, idcorrespondente);
		entityManager.merge(corr);
		return corr;
	}

}
