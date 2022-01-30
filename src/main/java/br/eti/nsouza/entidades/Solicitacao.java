package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Solicitacao",
		description = "Esta classe e contem as solcitacoes do sistema e a classe mais importante."
)
@Entity
@Table(name = "solicitacao")
@SequenceGenerator(name = "seqsolicitacao", sequenceName = "idsolicitacao", allocationSize = 1, initialValue = 1)
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqsolicitacao")
	private Integer idsolicitacao;
	private Integer referenciasolicitacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datasolictacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataconclusao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataprazo;
	@Column(length = 600, columnDefinition = "Text")
	private String observacao;
	@Column(length = 600, columnDefinition = "Text")
	private String instrucoes;
	@Column(length = 600, columnDefinition = "Text")
	private String complemento;
	@Column(length = 600, columnDefinition = "Text")
	private String justificativa;
	@Column(length = 600, columnDefinition = "Text")
	private String tratposaudiencia; //Tratamento pos audiencia
	@Column(length = 30)
	private String numcontrole;
	private boolean tempreposto;
	private boolean convolada;
	@Column(nullable = true, length = 10)
	private String horaudiencia;
	@Column(nullable = true, length = 20)
	private String statusexterno; // CONFIRMAR - REJEITAR

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idprocesso")
	private Processo processo;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idrenumeracao")
	private Renumeracao renumeracao;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idstatus")
	private StatusSolicitacao statusSolicitacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idcomarca")
	@NotBlank
	//@Column(nullable=false)
	private Comarca comarca;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idformulario")
	private FormularioAudiencia formularioAudiencia;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idbanca")
	@NotBlank
	private BancaProcesso bancaProcesso;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idenviosolicitacao")
	private Enviosolicitacao enviosolicitacao;
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idrecibo")
	private ReciboPagamento reciboPagamento;
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="idaudiinterna")
	private AuditoriaInterna auditoriaInterna;
	private float valor;
	private float valordaalcada;
	private String emailenvio;
	private String pago;
	private Integer grupo;
	@Column(nullable=true)
	private boolean propostaacordo;
	@Column(nullable=true)
	private boolean audinterna;
	public boolean isAudinterna() {
		return audinterna;
	}
	public void setAudinterna(boolean audinterna) {
		this.audinterna = audinterna;
	}
	public Integer getIdsolicitacao() {
		return idsolicitacao;
	}
	public void setIdsolicitacao(Integer idsolicitacao) {
		this.idsolicitacao = idsolicitacao;
	}
	public Integer getReferenciasolicitacao() {
		return referenciasolicitacao;
	}
	public void setReferenciasolicitacao(Integer referenciasolicitacao) {
		this.referenciasolicitacao = referenciasolicitacao;
	}

	public Date getDatasolictacao() {
		return datasolictacao;
	}
	public void setDatasolictacao(Date datasolictacao) {
		this.datasolictacao = datasolictacao;
	}
	public Date getDataprazo() {
		return dataprazo;
	}
	public void setDataprazo(Date dataprazo) {
		this.dataprazo = dataprazo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getInstrucoes() {
		return instrucoes;
	}
	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public String getTratposaudiencia() {
		return tratposaudiencia;
	}
	public void setTratposaudiencia(String tratposaudiencia) {
		this.tratposaudiencia = tratposaudiencia;
	}
	public String getNumcontrole() {
		return numcontrole;
	}
	public void setNumcontrole(String numcontrole) {
		this.numcontrole = numcontrole;
	}
	public boolean isTempreposto() {
		return tempreposto;
	}
	public void setTempreposto(boolean tempreposto) {
		this.tempreposto = tempreposto;
	}
	public boolean isConvolada() {
		return convolada;
	}
	public void setConvolada(boolean convolada) {
		this.convolada = convolada;
	}
	public String getHoraudiencia() {
		return horaudiencia;
	}
	public void setHoraudiencia(String horaudiencia) {
		this.horaudiencia = horaudiencia;
	}
	public String getStatusexterno() {
		return statusexterno;
	}
	public void setStatusexterno(String statusexterno) {
		this.statusexterno = statusexterno;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public Renumeracao getRenumeracao() {
		return renumeracao;
	}
	public void setRenumeracao(Renumeracao renumeracao) {
		this.renumeracao = renumeracao;
	}
	public StatusSolicitacao getStatusSolicitacao() {
		return statusSolicitacao;
	}
	public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}
	public Comarca getComarca() {
		return comarca;
	}
	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}
	public FormularioAudiencia getFormularioAudiencia() {
		return formularioAudiencia;
	}
	public void setFormularioAudiencia(FormularioAudiencia formularioAudiencia) {
		this.formularioAudiencia = formularioAudiencia;
	}
	public BancaProcesso getBancaProcesso() {
		return bancaProcesso;
	}
	public void setBancaProcesso(BancaProcesso bancaProcesso) {
		this.bancaProcesso = bancaProcesso;
	}
	public Enviosolicitacao getEnviosolicitacao() {
		return enviosolicitacao;
	}
	public void setEnviosolicitacao(Enviosolicitacao enviosolicitacao) {
		this.enviosolicitacao = enviosolicitacao;
	}
	public ReciboPagamento getReciboPagamento() {
		return reciboPagamento;
	}
	public void setReciboPagamento(ReciboPagamento reciboPagamento) {
		this.reciboPagamento = reciboPagamento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getValordaalcada() {
		return valordaalcada;
	}
	public void setValordaalcada(float valordaalcada) {
		this.valordaalcada = valordaalcada;
	}
	public String getEmailenvio() {
		return emailenvio;
	}
	public void setEmailenvio(String emailenvio) {
		this.emailenvio = emailenvio;
	}
	public String getPago() {
		return pago;
	}
	public void setPago(String pago) {
		this.pago = pago;
	}
	public Integer getGrupo() {
		return grupo;
	}
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}
	public boolean isPropostaacordo() {
		return propostaacordo;
	}
	public void setPropostaacordo(boolean propostaacordo) {
		this.propostaacordo = propostaacordo;
	}
	public AuditoriaInterna getAuditoriaInterna() {
		return auditoriaInterna;
	}
	public void setAuditoriaInterna(AuditoriaInterna auditoriaInterna) {
		this.auditoriaInterna = auditoriaInterna;
	}
	public Date getDataconclusao() {
		return dataconclusao;
	}
	public void setDataconclusao(Date dataconclusao) {
		this.dataconclusao = dataconclusao;
	}

	
}
