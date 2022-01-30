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
		value       = "Classe Endereço",
		description = "Esta classe e contem os endereço do correspondente."
)
@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seqendereco", sequenceName = "idendereco", allocationSize = 1, initialValue = 1)
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqendereco")
	private Integer idendereco;
	private String logradouro;
	private String bairro;
	private String cidade;
	@ManyToOne
	private Uf uf;
	private String cep;
	private String observacao;
	public Integer getIdendereco() {
		return idendereco;
	}
	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


}
