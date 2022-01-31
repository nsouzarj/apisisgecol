package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Preposto",
		description = "Esta classe de preposto da solicitacao de audiencia."
)
@Entity
@Table(name = "preposto")
@SequenceGenerator(initialValue = 1, name = "seqpreposto", sequenceName = "seqpreposto")
public class Preposto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqpreposto")
	private Integer idpresposto;
	private String nomecompleto;
	private String cpf;
	private String identidade;
	private Date datanascimento;
	private String observacao;
	@ManyToOne
	@JoinColumn (name = "enderecos_idendereco")
	private Endereco enderecos;

}
