package proyectos.modelo.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String cif;

	private String nombre;

	private String apellidos;

	private String domicilio;

	@Column(name = "facturacion_anual")
	private double facturacionAnual;

	@Column(name = "numero_empleados")
	private int numeroEmpleados;

}
