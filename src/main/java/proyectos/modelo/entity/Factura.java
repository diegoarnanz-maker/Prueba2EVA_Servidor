package proyectos.modelo.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_factura")
	private String idFactura;

	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;

}
