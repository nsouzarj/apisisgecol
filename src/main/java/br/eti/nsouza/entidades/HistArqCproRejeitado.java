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
		value       = "Classe HistArqCproRejeitado",
		description = "Esta classe sao dos arquivos do cppro rejeitados."
)
@Entity
@Table(name = "histarqcpprorej")
@SequenceGenerator(name = "seqhistcprorej", sequenceName = "idarqcpprorej", allocationSize = 1, initialValue = 1)
public class HistArqCproRejeitado implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhistcprorej")
	private Integer idarqcpprorej;
	private Integer idarquivocppro;
	private Date rejeitadoem;
	@Column(columnDefinition="TEXT")
    private String motivo;

}
