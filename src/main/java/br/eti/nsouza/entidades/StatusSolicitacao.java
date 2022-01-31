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
		value       = "Classe StatusSolicitacao",
		description = "Esta classe sao do status do solcitacao."
)
@Entity
@Table(name = "statussolicitacao")
@SequenceGenerator(name = "seqstatus", sequenceName = "idstatus", allocationSize = 1, initialValue = 1)
public class StatusSolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqstatus")
	private Integer idstatus;
	private String status;

}
