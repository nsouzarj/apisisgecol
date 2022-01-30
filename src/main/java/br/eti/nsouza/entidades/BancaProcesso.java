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
		value       = "Classe Banca",
		description = "Esta classe e contem as bancas do processo."
)
@Entity
@Table(name = "bancaprocesso")
@SequenceGenerator(name = "seqbanca", sequenceName = "idbanca", allocationSize = 1, initialValue = 1)
public class BancaProcesso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqbanca")
	private Integer idbanca;
	private String banca;
	private String descricao;
	private boolean ativa;
	private String email; //Email da banca 
	private String emailgestordabanca; //Email do gestor da banca
	public Integer getIdbanca() {
		return idbanca;
	}
	public void setIdbanca(Integer idbanca) {
		this.idbanca = idbanca;
	}
	public String getBanca() {
		return banca;
	}
	public void setBanca(String banca) {
		this.banca = banca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailgestordabanca() {
		return emailgestordabanca;
	}
	public void setEmailgestordabanca(String emailgestordabanca) {
		this.emailgestordabanca = emailgestordabanca;
	}


}
