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
@Table(name = "comarca")
@SequenceGenerator(name = "seqcomarca", sequenceName = "idcomarca", allocationSize = 1, initialValue = 1)
public class Comarca implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcomarca")
	private Integer idcomarca;
	private String nome;
	@ManyToOne
	private Uf uf;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public Integer getIdcomarca() {
		return idcomarca;
	}
	public void setIdcomarca(Integer idcomarca) {
		this.idcomarca = idcomarca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}

}