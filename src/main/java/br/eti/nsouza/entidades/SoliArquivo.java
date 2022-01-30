package br.eti.nsouza.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "arquivoanexado")
public class SoliArquivo implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private SolicitacaoPossuiArquivo solicitacaoPossuiArquivo;

	public SolicitacaoPossuiArquivo getSolicitacaoPossuiArquivo() {
		return solicitacaoPossuiArquivo;
	}

	public void setSolicitacaoPossuiArquivo(
			SolicitacaoPossuiArquivo solicitacaoPossuiArquivo) {
		this.solicitacaoPossuiArquivo = solicitacaoPossuiArquivo;
	}

}
