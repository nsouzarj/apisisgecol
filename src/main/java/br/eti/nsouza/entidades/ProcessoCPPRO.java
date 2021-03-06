/**
 * 
 */
package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nelson
 * Esta tabela guarda os processo do cprpo que ficam armazenado em planilha
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe ProcessoCPPRO",
		description = "Esta classe e contem os ProcessoCPPRO."
)
@Entity
@Table(name = "processocppro")
@SequenceGenerator(name = "seqprocessocppro", sequenceName = "idprocessocppro", allocationSize = 1, initialValue = 1)
public class ProcessoCPPRO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqprocessocppro")
	private Integer idprocessocppro;
	private String numprocesso;
	private String cliente;
	private String orgaoinicial;
	private String partecontraria;
	@Column(length = 600, columnDefinition = "Text")
	private String acao;
	private String localizador;
	private String eletronico;

}
