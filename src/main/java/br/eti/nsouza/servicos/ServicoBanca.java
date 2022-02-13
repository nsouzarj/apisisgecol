package br.eti.nsouza.servicos;
import br.eti.nsouza.entidades.BancaProcesso;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;
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
