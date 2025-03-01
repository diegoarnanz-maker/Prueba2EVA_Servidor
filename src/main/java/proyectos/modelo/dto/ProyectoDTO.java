package proyectos.modelo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProyectoDTO {
    private String idProyecto;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinPrevisto;
    private String fechaFinReal;
    private String estado; //En entoty es ENUM
    private String jefeProyecto;
    private String cliente;
}
// sin ventaPrevisto, costesPrevisto, costeReal
// FechaInicio, FechaFinPrevisto y FechaFinReal son String en lugar de LocalDate 
// JefeProyecto y Cliente son String en lugar de objetos para no tener que enviar TODO