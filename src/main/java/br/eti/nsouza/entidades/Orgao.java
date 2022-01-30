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
		value       = "Classe Orgao",
		description = "Esta classe os orgaos do processo."
)
@Entity
@Table(name = "orgao")
@SequenceGenerator(name = "seqorgao", sequenceName = "idorgao", allocationSize = 1, initialValue = 1)
public class Orgao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqorgao")
	private Integer idorgao;
	@Column(length = 50)
	private String descricao;
	public Integer getIdorgao() {
		return idorgao;
	}
	public void setIdorgao(Integer idorgao) {
		this.idorgao = idorgao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
