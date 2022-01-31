package br.eti.nsouza.servicos;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.nsouza.entidades.ComarcaPossui;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoComarcaPossui {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<ComarcaPossui> findByid(Integer idcorrespondente) {
		
		return entityManager
				.createQuery("from ComarcaPossui S where S.comarcaCorrespondente.correspondente.idcorrespondente=?1")
				.setParameter(1, idcorrespondente).getResultList();
	}
	@Transactional
	public ComarcaPossui salvar(ComarcaPossui comarcaPossui) throws SQLException {
	   	entityManager.persist(comarcaPossui);
		return comarcaPossui;
	}

	@Transactional
	public void excluir(ComarcaPossui comarcaPossui) throws SQLException {
	   	entityManager.remove(comarcaPossui);
	}
	
}
