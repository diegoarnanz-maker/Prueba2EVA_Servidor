package proyectos.modelo.dto_examen;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProyectoDTOExamen {

    private String idProyecto;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinReal;
    
}
