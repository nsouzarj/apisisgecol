package br.eti.nsouza.entidades;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel (
		value       = "Classe PerfilUsuario",
		description = "Esta classe os pefils dos usuários."
)
@Entity
@Table(name = "perfilusuario")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "seqperfil", sequenceName = "idperfil")
public class PerfilUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqperfil")
	private Integer idperfilusuario;
	private String perfil;
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
}
