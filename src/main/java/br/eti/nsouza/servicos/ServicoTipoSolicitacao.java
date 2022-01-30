package br.eti.nsouza.servicos;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.TipoSolicitacao;

@Service
public class ServicoTipoSolicitacao {

	@Autowired
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

	public TipoSolicitacao save(TipoSolicitacao post) {
		entityManager.persist(post);
		return post;
	}

	public void delete(TipoSolicitacao post) {
		entityManager.remove(post);
	}

}
