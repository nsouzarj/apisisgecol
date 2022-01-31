package br.eti.nsouza.entidades;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * Arquivos do cpro
 * 
 * @author Nelson
 * Esta classe e a tabela dos arquivos salos do cppro
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Arquivo CPPROSalvo",
		description = "Esta classe e contem os arquivo do cpprosalvo."
)
@Entity
@Table(name = "anexocprosalvo")
@SequenceGenerator(name = "seqcprposalvo", sequenceName = "idarqcpprosalvo", allocationSize = 1, initialValue = 1)
public class ArquivoAnexoCPROSalvo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcprposalvo")
	private Integer idarqcpprosalvo;
	private Integer idArquivo;
	private Integer idContexto;
	private Integer idsolicitacao;
	private String PastaDoProcesso;
	private String NomeDocumento;
	private String CaminhoGed;
	private String AnexadoPor;
	private String TipoDocumento;
	private String Descricao;
	private Date AnexadoEm;
	private Date BaixadoEm;
	private boolean baixado;
	private boolean rejeitado;
	@ManyToOne
	@JoinColumn (name = "rejeitadopor_idusuario")
	private Usuario rejeitadopor; //N�o tem funcionalidade
	private Date datareijeicao;
	@Column(columnDefinition = "TEXT")
	private String motivodarejeicao;

}
