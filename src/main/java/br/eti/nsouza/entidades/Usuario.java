package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("deprecation")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe Usuario",
		description = "Esta classe e dos usuarios do estado."
)
@Entity
@Table(name = "usuario")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "sequsu", sequenceName = "idusuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequsu")
	private Integer idusuario;
	private String login;
	private String senha;
	private String nomecompleto;
	@Email
	private String emailprincipal;
	@Email
	private String emailsecundario;
	@Email
	private String emailresponsavel;
    @OneToOne
    private Correspondente correspondente;
	private Integer tipo; // 1-Adm, 2-Advgodado, 3-Correspondente
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataentrada;
	private boolean ativo;

}
