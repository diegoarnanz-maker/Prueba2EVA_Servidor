package proyectos.modelo.dto_examen;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDTOExamen {

    private String apellidoYNombre;
    private int horasTotales;
    private double importeRepercutido;
    
}
