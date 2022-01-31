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
		value       = "Classe FormularioAudiencia",
		description = "Esta classe sao dos formulario de envio."
)
@Entity
@Table(name = "formularioaudiencia")
@SequenceGenerator(name = "seqformulario", sequenceName = "idformulario", allocationSize = 1, initialValue = 1)
public class FormularioAudiencia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqformulario")
	private Integer idformulario;
	private String nomeadvogado;
	private String numoab;
	private String telefoneadvogado;
	private String advogadoadverso;
	private String numoabadverso;
	private String telefoneadvadervoso;
	private String emailadvadverso;
	private boolean defesagenerica;
	private boolean contraproposta;
	private boolean aijdesiginada;
	private Date dataaij;
	private double valorproposta;
	private double valorcontraproposta;
    @Column(length = 1000, columnDefinition = "Text")
	private String obrigacaoafazer;
    @Column(length = 1000, columnDefinition = "Text")
	private String informecontraproposta;
    @Column(length = 1000, columnDefinition = "Text")
	private String objetodalide;
    @Column(length = 1000, columnDefinition = "Text")
	private String estrategiadefesa;
    @Column(length = 1000, columnDefinition = "Text")
	private String informeacontecimento;
	private Integer nivel;
	private Date dataformulario;
	private boolean acordorealizado;
	private double valoracordo;
}
