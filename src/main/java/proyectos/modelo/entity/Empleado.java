package proyectos.modelo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empl")
	private int idEmpl;

	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private double salario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name = "id_depar")
	private Departamento departamento;

}
