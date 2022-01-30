package br.eti.nsouza.servicos;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.nsouza.entidades.BancaProcesso;
;

@Service
public class ServicoBanca {
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<BancaProcesso> findAll() {
		List<BancaProcesso> bancas = entityManager.createQuery("from BancaProcesso order by banca").getResultList();
		return bancas;
	}

	public BancaProcesso findOne(Integer idbanca) {
		BancaProcesso com = entityManager.find(BancaProcesso.class, idbanca);
		return com;
	}
	
	public BancaProcesso save(BancaProcesso post) {
		entityManager.getTransaction().begin();
		entityManager.persist(post);
		entityManager.getTransaction().commit();
		return post;
	}
	
	public void delete(Integer idbanca) {
		entityManager.getTransaction().begin();
		BancaProcesso soli = entityManager.find(BancaProcesso.class, idbanca);
		entityManager.remove(soli);
		entityManager.getTransaction().commit();
	}
		
	

}
