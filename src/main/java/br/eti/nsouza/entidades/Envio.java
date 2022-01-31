package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/**
 * Classe de teste
 * @author Nelson
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Envio",
		description = "Esta os tipos de envio da solicitacao."
)
@Entity
@Table(name = "envio")
@SequenceGenerator(name = "seqenvio", sequenceName = "idenvio", initialValue = 1, allocationSize = 1)
public class Envio  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqenvio")
	private Integer idenvio;
	private String descricao;
}
