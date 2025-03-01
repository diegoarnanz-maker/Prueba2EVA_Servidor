package proyectos.modelo.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_depar")
	private int idDepar;

	private String nombre;
	private String direccion;

}
