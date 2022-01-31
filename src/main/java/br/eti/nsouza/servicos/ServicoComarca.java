package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.nsouza.entidades.Comarca;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoComarca {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Comarca> findAll() {
		List<Comarca>  comarca=  entityManager.createQuery("from Comarca order by nome").getResultList();
	  return comarca;
	}
	
	public List<Comarca>buscaEstado(Integer iduf){
	    List<Comarca>  comarcaporestado=entityManager.createQuery("from Comarca where uf.iduf='" + iduf + "' order by nome").getResultList();
		return comarcaporestado;
	}
	

	public Comarca findOne(Integer idcomarca) {
	    Comarca com =entityManager.find(Comarca.class, idcomarca);
		return com;
	}

	@Transactional
	public void delete(Integer idcomarca) {
		Comarca com = entityManager.find(Comarca.class, idcomarca);
		entityManager.remove(com);

	}

	@Transactional
	public Comarca update(Integer idcomarca) {
		Comarca com = entityManager.find(Comarca.class, idcomarca);
		entityManager.merge(com);
		return com;
	}
	 
}
