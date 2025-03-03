package proyectos.modelo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProyectoConEmpleadosDTO {
    private int numeroOrden;
    private String idProyecto;
    private String nombreProyecto;
    private int idEmpleado;
    private String nombreEmpleado;
    private int horasAsignadas;
    private String fechaIncorporacion;
}

// idProyecto String e idEmpleado int en lugar de Proyecto y Empleado objetos
//en funcion de lo que se quiera enviar podria omitirse el idEmpleado y el idProyecto y dejar solo los nombres, en este caso se deja asi
