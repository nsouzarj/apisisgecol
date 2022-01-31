package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe SolicitacaoAnexo",
		description = "Esta classe sao de anexos de solictacao."
)
@Entity
@Table(name = "arquivosanexo")
@SequenceGenerator(name = "seqanexo", sequenceName = "idarquivoanexo", allocationSize = 1, initialValue = 1)
public class SolicitacaoAnexo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqanexo")
	private Integer idarquivoanexo;
	@Lob
	@Transient
	private byte[] arquivo;
	private String linkarquivo;
	private Date datasolicitacao;
	private String tipoarquivo;
	private String nomearquivo;
	private String operacao; // Entrada ou Saida
	private Integer origemarq;   // 1 - Siegecol 2-Cprpo
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
}
