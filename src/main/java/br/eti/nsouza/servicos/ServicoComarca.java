package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.nsouza.entidades.Comarca;

@Service
public class ServicoComarca {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Comarca> findAll() {
		List<Comarca>  comarca=  entityManager.createQuery("from Comarca order by nome").getResultList();
	  return comarca;
	}
	
	public List<Comarca>buscaEstado(Integer iduf){
		@SuppressWarnings("unchecked")
		
		List<Comarca>  comarcaporestado=entityManager.createQuery("from Comarca where uf.iduf='" + iduf + "' order by nome").getResultList();
		return comarcaporestado;
	}
	

	public Comarca findOne(Integer idcomarca) {
	    Comarca com =entityManager.find(Comarca.class, idcomarca);
		return com;
	}

	
	public void delete(Integer idcomarca) {
		entityManager.getTransaction().begin();
		Comarca com = entityManager.find(Comarca.class, idcomarca);
		entityManager.remove(com);
		entityManager.getTransaction().commit();
	}
	
	public Comarca update(Integer idcomarca) {
		entityManager.getTransaction().begin();
		Comarca com = entityManager.find(Comarca.class, idcomarca);
		entityManager.merge(com);
		entityManager.getTransaction().commit();
		return com;
	}
	 
}
