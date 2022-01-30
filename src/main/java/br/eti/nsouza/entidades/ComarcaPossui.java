package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe ComarcaPossui",
		description = "Esta classe e contem as as comarcas dos correspondentes."
)
@Entity
@Table(name = "comarcapossui")
@SequenceGenerator(name = "seqcomarcapossui", sequenceName = "idcomarcapossui", allocationSize = 1, initialValue = 1)
public class ComarcaPossui implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ComarcaCorrespondente comarcaCorrespondente;
	private boolean inativado;
	public boolean isInativado() {
		return inativado;
	}
	public void setInativado(boolean inativado) {
		this.inativado = inativado;
	}
	public ComarcaCorrespondente getComarcaCorrespondente() {
		return comarcaCorrespondente;
	}
	public void setComarcaCorrespondente(
			ComarcaCorrespondente comarcaCorrespondente) {
		this.comarcaCorrespondente = comarcaCorrespondente;
	}


	
	
	

}
