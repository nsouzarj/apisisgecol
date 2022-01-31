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
		value       = "Classe Banco",
		description = "Esta classe e contem as bancarias do correspondente."
)
@Entity
@Table(name = "banco")
@SequenceGenerator(name = "seqbanco", sequenceName = "idbanco", allocationSize = 1, initialValue = 1)
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqbanco")
	private Integer idbanco;
	private String codbanco;
	private String agencia;
	private String banco;
	private String contacorrente;
	@ManyToOne
	private Correspondente correspondente;

}
