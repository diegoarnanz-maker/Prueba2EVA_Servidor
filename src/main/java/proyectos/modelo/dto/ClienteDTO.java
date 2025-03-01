package proyectos.modelo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private String cif;
    private String nombre;
    private String apellidos;
    private String domicilio;
}

//Sin facturacionAnual y numeroEmpleados