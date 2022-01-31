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
		value       = "Classe Losistema",
		description = "Esta classe sao dos logs do sistema."
)
@Entity
@Table(name = "logsistema")
@SequenceGenerator(name = "seqlog", sequenceName = "idlog", allocationSize = 1, initialValue = 1)
public class LogSistema implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqlog")
	private Integer idlog;
	private String usuario;
	private Integer idsolicitacao;
	private Date datalog;
	private String tela;
	@Column(length=3000,columnDefinition="Text")
	private String descricao;

	
}
