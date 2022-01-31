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
		value       = "Classe Comarca",
		description = "Esta classe e contem as comarcas dos estaados."
)
@Entity
@Table(name = "emailscorrespondente")
@SequenceGenerator(initialValue = 1, name = "seqemail", sequenceName = "idemail", allocationSize = 1)
public class EmailCorrespondente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqemail")
	private Integer idemail;
	@Column(length = 100)
	private String email;
	@ManyToOne
	private Correspondente correspondente;
	public Integer getIdemail() {
		return idemail;
	}
    public void setIdemail(Integer idemail) {
		this.idemail = idemail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Correspondente getCorrespondente() {
		return correspondente;
	}
	public void setCorrespondente(Correspondente correspondente) {
		this.correspondente = correspondente;
	}


}
