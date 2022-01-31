package br.eti.nsouza.servicos;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.nsouza.entidades.BancaProcesso;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
;

@Service
public class ServicoBanca {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<BancaProcesso> findAll() {
		List<BancaProcesso> bancas = entityManager.createQuery("from BancaProcesso order by banca").getResultList();
		return bancas;
	}

	public BancaProcesso findOne(Integer idbanca) {
		BancaProcesso com = entityManager.find(BancaProcesso.class, idbanca);
		return com;
	}

	@Transactional
	public BancaProcesso save(BancaProcesso post) throws SQLException {
		entityManager.persist(post);
		return post;
	}

	@Transactional
	public void delete(Integer idbanca) throws Exception {
		BancaProcesso soli = entityManager.find(BancaProcesso.class, idbanca);
		entityManager.remove(soli);

	}



}
