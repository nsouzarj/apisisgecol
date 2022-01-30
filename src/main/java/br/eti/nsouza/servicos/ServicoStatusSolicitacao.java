package br.eti.nsouza.servicos;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.nsouza.entidades.StatusSolicitacao;

@Service
public class ServicoStatusSolicitacao {
	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<StatusSolicitacao> findAll() {
		
		List<StatusSolicitacao> st= entityManager.createQuery("from StatusSolicitacao").getResultList();
		return st;
	}

		
	public StatusSolicitacao buscar(Integer idstatus) {
		StatusSolicitacao rep =entityManager.find(StatusSolicitacao.class, idstatus);
		return rep;
	}
	
	
	

}
