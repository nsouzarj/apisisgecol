package br.eti.nsouza.servicos;

import br.eti.nsouza.entidades.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
@Service
public class ServicoSolicitacao {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Solicitacao> findAll() {
		List<Solicitacao> teste =entityManager.createQuery("from Solicitacao order by datasolictacao asc ").setFirstResult(0).setMaxResults(300).getResultList();
		return teste;
	}

	public Solicitacao findById (Integer idsolicitacao) {
		Solicitacao soli=entityManager.find(Solicitacao.class, idsolicitacao);
		return soli;
	}
	/**
	 * Salva a solicitacao
	 * @param post
	 * @return
	 */
	public Solicitacao save(Solicitacao post) {
		entityManager.getTransaction().begin();
		entityManager.persist(post);
		entityManager.getTransaction().commit();
		return post;
    }
	/**
	 * Deleta a spolicitacao
	 * @param idsolicitacao
	 */
	
	public void delete(Integer idsolicitacao) {
		entityManager.getTransaction().begin();
		Solicitacao soli = entityManager.find(Solicitacao.class, idsolicitacao);
		entityManager.remove(soli);
		entityManager.getTransaction().commit();
	}
	/**
	 * Aletra a solitcitacacao
	 * @param idsolicitacao
	 * @return
	 */
	public Solicitacao update(Integer idsolicitacao) {
		entityManager.getTransaction().begin();
		Solicitacao soli = entityManager.find(Solicitacao.class, idsolicitacao);
		entityManager.merge(soli);
		entityManager.getTransaction().commit();
		return soli;
	}
}


