package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe HistArqCpro",
		description = "Esta classe sao dos arquivos cppro."
)
@Entity
@Table(name = "histarqcppro")
@SequenceGenerator(name = "seqhistcpro", sequenceName = "idarqcppro", allocationSize = 1, initialValue = 1)
public class HistArqCpro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhistcpro")
	private Integer idarqcppro;
	@OneToOne
	private SolicitacaoAnexo solicitacaoAnexo;
	private Integer idarquivocppro;
	private Date salvoem;

}
