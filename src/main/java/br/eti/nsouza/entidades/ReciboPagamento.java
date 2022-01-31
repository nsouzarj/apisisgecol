package br.eti.nsouza.entidades;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Comarca",
		description = "Esta classe e contem as comarcas dos estaados."
)

@Entity
@Table(name = "recibopagamento")
@SequenceGenerator(initialValue = 1, name = "seqpag", sequenceName = "seqpag", allocationSize = 1)
public class ReciboPagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqpag")
	private Integer idrecibo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datafechamento;
	private String anotacao;
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
}
