package proyectos.modelo.dto_examen;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDTOExamen {

    private String idFactura;
    private String descripcion;
    private LocalDate fechaFactura;

    private ClienteDTOExamen cliente;
    private ProyectoDTOExamen proyecto;

    //Detalles de la factura
    private List<EmpleadoDTOExamen> detalleEmpleado;

    private int totalHoras;
    private double ventaPrevisto;
    private double totalFacturado;
}
