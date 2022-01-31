package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.TipoSolicitacao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicoTipoSolicitacao {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<TipoSolicitacao>  findAll() {
		
		List<TipoSolicitacao> tipo =  entityManager.createQuery("select idtiposolicitacao,"
				+ "tipo,visualizar  from TipoSolicitacao ").getResultList();
		return tipo;

	}

	public TipoSolicitacao findOne(Integer idtiposolicitacao) {
		TipoSolicitacao com = entityManager.find(TipoSolicitacao.class, idtiposolicitacao);
		return com;
	}
	@Transactional
	public TipoSolicitacao save(TipoSolicitacao post) {
		entityManager.persist(post);
		return post;
	}
	@Transactional
	public void delete(TipoSolicitacao post) {
		entityManager.remove(post);
	}

}
