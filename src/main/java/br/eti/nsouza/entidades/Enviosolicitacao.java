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
		value       = "Classe Enviosolicitacao",
		description = "Esta os tipos de envio da solicitacao."
)
@Entity
@Table(name = "enviode")
@SequenceGenerator(name = "seqenviosoli", sequenceName = "idenviosolicitacao", allocationSize = 1, initialValue = 1)
public class Enviosolicitacao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqenviosoli")
	private Integer idenviosolicitacao;
	private String tipoenvio;

}
