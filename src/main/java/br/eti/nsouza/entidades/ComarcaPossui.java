package br.eti.nsouza.entidades;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "comarcapossui")
@SequenceGenerator(name = "seqcomarcapossui", sequenceName = "idcomarcapossui", allocationSize = 1, initialValue = 1)
public class ComarcaPossui implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcomarcapossui")
	private Integer idcomarcapossui;
	//@EmbeddedId
	private ComarcaCorrespondente comarcaCorrespondente;
	private boolean inativado;

	public ComarcaPossui() {

	}

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

	@Override
	public String toString() {
		return "ComarcaPossui [comarcaCorrespondente=" + comarcaCorrespondente
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (inativado ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComarcaPossui other = (ComarcaPossui) obj;
		if (inativado != other.inativado)
			return false;
		return true;
	}

	
	

	
	
	

}
