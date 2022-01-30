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
		value       = "Classe Processo",
		description = "Esta classe e contem os processos da solcitacao"
)
@Entity
@Table(name = "processo")
@SequenceGenerator(name = "seqprocesso", sequenceName = "idprocesso", allocationSize = 1, initialValue = 1)
public class Processo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqprocesso")
	private Integer idprocesso;
	private String numeroprocesso;
	private String numeroprocessopesq;
	private String parte;
	private String adverso;
	private String posicao;
	private String status;
	private String cartorio;
	@Column(length = 600, columnDefinition = "Text")
	private String assunto;
	private String localizacao;
	private String numerointegracao;
	@OneToOne(fetch=FetchType.EAGER)
	private Comarca comarca;
	@OneToOne(fetch=FetchType.EAGER)
	private Orgao orgao;
	private Integer numorgao;
	private String proceletronico;
	private Integer quantsoli;
	@Transient
	private Integer totalfeita;
	public Integer getQuantsoli() {
		return quantsoli;
	}
	public void setQuantsoli(Integer quantsoli) {
		this.quantsoli = quantsoli;
	}
	public String getProceletronico() {
		return proceletronico;
	}
	public void setProceletronico(String proceletronico) {
		this.proceletronico = proceletronico;
	}
	public String getNumeroprocessopesq() {
		return numeroprocessopesq;
	}
	public void setNumeroprocessopesq(String numeroprocessopesq) {
		this.numeroprocessopesq = numeroprocessopesq;
	}
	public String getNumerointegracao() {
		return numerointegracao;
	}
	public void setNumerointegracao(String numerointegracao) {
		this.numerointegracao = numerointegracao;
	}
	public Integer getIdprocesso() {
		return idprocesso;
	}
	public void setIdprocesso(Integer idprocesso) {
		this.idprocesso = idprocesso;
	}
	public String getNumeroprocesso() {
		return numeroprocesso;
	}
	public void setNumeroprocesso(String numeroprocesso) {
		this.numeroprocesso = numeroprocesso;
	}
	public String getParte() {
		return parte;
	}
	public void setParte(String parte) {
		this.parte = parte;
	}
	public String getAdverso() {
		return adverso;
	}
	public void setAdverso(String adverso) {
		this.adverso = adverso;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCartorio() {
		return cartorio;
	}
	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Comarca getComarca() {
		return comarca;
	}
	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}
	public Orgao getOrgao() {
		return orgao;
	}
	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}
	public Integer getNumorgao() {
		return numorgao;
	}
	public void setNumorgao(Integer numorgao) {
		this.numorgao = numorgao;
	}

}
