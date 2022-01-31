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
		value       = "Classe SmsSalvo",
		description = "Esta classe e contem os sms salvos."
)
@Entity
@Table(name = "smsalvo")
@SequenceGenerator(name = "seqsms", sequenceName = "idsms", allocationSize = 1, initialValue = 1)
public class SmsSalvo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idsms;
	@ManyToOne
	@JoinColumn (name = "usuario_idusuario")
	private Usuario  usuario;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataenvio;
	private String numero;
	private String menssagem;

}
