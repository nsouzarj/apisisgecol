package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Correspondente",
		description = "Esta classe e contem os dados do correspondente."
)

@Entity
@Table(name = "correspondente")
@SequenceGenerator(name = "seqcorrespondente", sequenceName = "idcorrespondente", allocationSize = 1, initialValue = 1)
public class Correspondente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcorrespondente")
	private Integer idcorrespondente;
	private String nome;
	private String responsavel;
	private String cpfcnpj;
	private String oab;
	private String tipocorrepondente;
	private String telefoneprimario;
	private String telefonesecundario;
	private String telefonecelularprimario;
	private String telefonecelularsecundario;
	@SuppressWarnings("deprecation")
	@Email
	private String emailprimario;
	@SuppressWarnings("deprecation")
	@Email
	private String emailsecundario;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datacadastro;
	private boolean ativo;
	private String observacao;
	@OneToOne
	private Endereco enderecos;
	private boolean aplicaregra1;
	private boolean aplicaregra2;
	public Integer getIdcorrespondente() {
		return idcorrespondente;
	}
	public void setIdcorrespondente(Integer idcorrespondente) {
		this.idcorrespondente = idcorrespondente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	public String getOab() {
		return oab;
	}
	public void setOab(String oab) {
		this.oab = oab;
	}
	public String getTipocorrepondente() {
		return tipocorrepondente;
	}
	public void setTipocorrepondente(String tipocorrepondente) {
		this.tipocorrepondente = tipocorrepondente;
	}
	public String getTelefoneprimario() {
		return telefoneprimario;
	}
	public void setTelefoneprimario(String telefoneprimario) {
		this.telefoneprimario = telefoneprimario;
	}
	public String getTelefonesecundario() {
		return telefonesecundario;
	}
	public void setTelefonesecundario(String telefonesecundario) {
		this.telefonesecundario = telefonesecundario;
	}
	public String getTelefonecelularprimario() {
		return telefonecelularprimario;
	}
	public void setTelefonecelularprimario(String telefonecelularprimario) {
		this.telefonecelularprimario = telefonecelularprimario;
	}
	public String getTelefonecelularsecundario() {
		return telefonecelularsecundario;
	}
	public void setTelefonecelularsecundario(String telefonecelularsecundario) {
		this.telefonecelularsecundario = telefonecelularsecundario;
	}

	public String getEmailprimario() {
		return emailprimario;
	}
	public void setEmailprimario(String emailprimario) {
		this.emailprimario = emailprimario;
	}
	public String getEmailsecundario() {
		return emailsecundario;
	}
	public void setEmailsecundario(String emailsecundario) {
		this.emailsecundario = emailsecundario;
	}
	public Date getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public boolean isAplicaregra1() {
		return aplicaregra1;
	}
	public Endereco getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}
	public void setAplicaregra1(boolean aplicaregra1) {
		this.aplicaregra1 = aplicaregra1;
	}
	public boolean isAplicaregra2() {
		return aplicaregra2;
	}
	public void setAplicaregra2(boolean aplicaregra2) {
		this.aplicaregra2 = aplicaregra2;
	}
}
