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
		value       = "Classe TipoSolicitacao",
		description = "Esta classe os tipos de solicitação."
)
@Entity
@Table(name = "tiposolicitacao")
@SequenceGenerator(name = "seqtiposolicitacao", sequenceName = "idtiposolicitacao", allocationSize = 1, initialValue = 1)
public class TipoSolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqtiposolicitacao")
	private Integer idtiposolicitacao;
	private String especie;
	private String descricao;
	private String tipo;
	private Boolean visualizar;

}
