package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.nsouza.entidades.ComarcaPossui;

@Service
public class ServicoComarcaPossui {
	@Autowired
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<ComarcaPossui> findByid(Integer idcorrespondente) {
		
		return entityManager
				.createQuery("from ComarcaPossui S where S.comarcaCorrespondente.correspondente.idcorrespondente=?1")
				.setParameter(1, idcorrespondente).getResultList();
	}
	
	public ComarcaPossui salvar(ComarcaPossui comarcaPossui) {
		entityManager.getTransaction().begin();
	   	entityManager.persist(comarcaPossui);
	 	entityManager.getTransaction().commit();
		return comarcaPossui;
	}
	
	public void excluir(ComarcaPossui comarcaPossui) {
		entityManager.getTransaction().begin();
	   	entityManager.remove(comarcaPossui);
	   	entityManager.getTransaction().commit();
	}
	
}
