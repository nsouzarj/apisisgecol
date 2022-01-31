package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe FormularioAudienciaNovo",
		description = "Esta classe sao dos formulario de envio."
)
@Entity(name="formaudnovo")
@SequenceGenerator(name = "seqformnovo", sequenceName = "idformnovo", allocationSize = 1, initialValue = 1)
public class FormularioAudienciaNovo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqformnovo")
	private Integer idformnovo;
	private boolean assitidoadvogado; //O autor est� assistido por por advogado
	private boolean autorcompaudiencia; //Autor compareceu a audiencia 
	private boolean encerrarformulario; //Encerra o formualrio nao presente mas nada
	private String telautor;//Telefone do autor
	private String emaildoautor; //Email do autor
	private boolean aijdesignada;// Aij desiganda
	private boolean acordorealizado; //Acordo realizado 
	private String oabexadverso; //Oab do exadverso
	private String telexadverso;// Telefone do exaadverso
	private String emailexadverso; //Email do exadverso
}
