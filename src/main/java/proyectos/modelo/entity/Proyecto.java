package proyectos.modelo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proyectos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proyecto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_proyecto")
	private String idProyecto;
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin_previsto")
	private LocalDate fechaFinPrevisto;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin_real")
	private LocalDate fechaFinReal;

	@Column(name = "venta_previsto")
	private double ventaPrevisto;

	@Column(name = "costes_previsto")
	private double costesPrevisto;

	@Column(name = "coste_real")
	private Double costeReal;

	@Enumerated(EnumType.STRING)
	private EstadoProyecto estado;

	@ManyToOne
	@JoinColumn(name = "jefe_proyecto")
	private Empleado jefeProyecto;

	@ManyToOne
	@JoinColumn(name = "cif")
	private Cliente cliente;

}
