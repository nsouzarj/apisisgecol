package br.eti.nsouza.entidades;

import javax.persistence.*;
import java.io.Serializable;

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

	public Orgao() {
	}

	public Orgao(Integer idorgao, String descricao) {
		this.idorgao = idorgao;
		this.descricao = descricao;
	}

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

	@Override
	public String toString() {
		return "Orgao [idorgao=" + idorgao + ", descricao=" + descricao + "]";
	}

}
