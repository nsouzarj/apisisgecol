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
		value       = "Classe Comarca",
		description = "Esta classe e contem as comarcas dos estaados."
)
@Entity
@Table(name = "auditoriainterna")
@SequenceGenerator(name = "seqaudiinterna", sequenceName = "idaudiinterna", allocationSize = 1, initialValue = 1)
public class AuditoriaInterna implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqaudiinterna")
	private Integer idaudiinterna; 
	private boolean correpfezsub; //Correspoendete se fez substituir
	private String advogadosubs; //Advogado substituto
    private boolean leuorientacao; //Leu a orienta��o porra !!
    private boolean conhecimentocaso; //Correspondente 
    private boolean duvpropacordo; //D�vida no acordo
    private boolean portdocumentacao; //Portava documentacao
    private float valorpropinicial; //valor da proposta inicial
    private Integer notaavaliacao;// Nota de avalaicao da audiencia
    @Column(length = 1000, columnDefinition = "Text")
    private String avaliacao1; //Avaliacao 1
    @Column(length = 1000, columnDefinition = "Text")
    private String avaliacao2; //Avaliacao 2
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataauditoria;
}
