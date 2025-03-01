package proyectos.modelo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proyecto_con_empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProyectoConEmpleados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "numero_orden")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroOrden;

	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;

	@ManyToOne
	@JoinColumn(name = "id_empl")
	private Empleado empleado;

	@Column(name = "horas_asignadas")
	private int horasAsignadas;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_incorporacion")
	private LocalDate fechaIncorporacion;

}
