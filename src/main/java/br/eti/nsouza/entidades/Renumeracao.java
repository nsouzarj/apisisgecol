package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Renumeracap",
		description = "Esta classe e contem a renumeração do corresponente."
)
@Entity
@Table(name = "renumeracao")
@SequenceGenerator(name = "seqrenumeracao", sequenceName = "idrenumeracao", allocationSize = 1, initialValue = 1)
public class Renumeracao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqrenumeracao")
	private Integer idrenumeracao;
	@Embedded
	private TipoSolicitacaoCorrespondente tipoSolicitacaoCorrespondente;
	// private ComarcaCorrespondente comarcaCorrespondente;
	private float valor;
	private boolean ativo;

	
}
