package br.eti.nsouza.entidades;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "historico")
@SequenceGenerator(name = "seqhist", sequenceName = "idhistorico", allocationSize = 1, initialValue = 1)
public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhist")
	private Integer idhistorico;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datahistorico;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idsolicitacao")
	private Solicitacao solicitacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idstatus")
	private StatusSolicitacao statusSolicitacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "idrenumeracao")
	private Renumeracao renumeracao;

	public Historico() {
	}

	public Historico(Integer idhistorico, Date datahistorico,
			Solicitacao solicitacao, StatusSolicitacao statusSolicitacao,
			Usuario usuario, Renumeracao renumeracao) {
		super();
		this.idhistorico = idhistorico;
		this.datahistorico = datahistorico;
		this.solicitacao = solicitacao;
		this.statusSolicitacao = statusSolicitacao;
		this.usuario = usuario;
		this.renumeracao = renumeracao;
	}

	public Integer getIdhistorico() {
		return idhistorico;
	}

	public void setIdhistorico(Integer idhistorico) {
		this.idhistorico = idhistorico;
	}

	public Date getDatahistorico() {
		return datahistorico;
	}

	public void setDatahistorico(Date datahistorico) {
		this.datahistorico = datahistorico;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public StatusSolicitacao getStatusSolicitacao() {
		return statusSolicitacao;
	}

	public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Renumeracao getRenumeracao() {
		return renumeracao;
	}

	public void setRenumeracao(Renumeracao renumeracao) {
		this.renumeracao = renumeracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datahistorico == null) ? 0 : datahistorico.hashCode());
		result = prime * result
				+ ((idhistorico == null) ? 0 : idhistorico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historico other = (Historico) obj;
		if (datahistorico == null) {
			if (other.datahistorico != null)
				return false;
		} else if (!datahistorico.equals(other.datahistorico))
			return false;
		if (idhistorico == null) {
			if (other.idhistorico != null)
				return false;
		} else if (!idhistorico.equals(other.idhistorico))
			return false;
		return true;
	}

}
