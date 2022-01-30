package br.eti.nsouza.entidades;

import javax.persistence.*;
import java.io.Serializable;

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

	public Comarca() {
	}

	public Comarca(Integer idcomarca, String nome, Uf uf) {
		this.idcomarca = idcomarca;
		this.nome = nome;
		this.uf = uf;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Comarca comarca = (Comarca) o;

		if (idcomarca != null ? !idcomarca.equals(comarca.idcomarca) : comarca.idcomarca != null) return false;
		if (nome != null ? !nome.equals(comarca.nome) : comarca.nome != null) return false;
		return uf != null ? uf.equals(comarca.uf) : comarca.uf == null;
	}

	@Override
	public int hashCode() {
		int result = idcomarca != null ? idcomarca.hashCode() : 0;
		result = 31 * result + (nome != null ? nome.hashCode() : 0);
		result = 31 * result + (uf != null ? uf.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Comarca{" +
				"idcomarca=" + idcomarca +
				", nome='" + nome + '\'' +
				", uf=" + uf +
				'}';
	}
}