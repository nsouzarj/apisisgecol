package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe SoliArquivo",
		description = "Esta classe e contem os arquivos anexos da solivtacao."
)
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
