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
		value       = "Classe Uf",
		description = "Esta classe as unidades e siglas do estado."
)
@Entity
@Table(name = "uf")
@SequenceGenerator(name = "sequf", sequenceName = "sequf", initialValue = 1, allocationSize = 1)
public class Uf implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequf")
	private Integer iduf;
	@Column(length = 2)
	private String sigla;
	@Column(length = 60)
	private String nome;
}
