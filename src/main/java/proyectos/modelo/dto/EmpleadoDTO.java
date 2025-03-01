package proyectos.modelo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDTO {
    private int idEmpl;
    private String nombre;
    private String apellidos;
    private String email;
    private double salario;
    private String perfil;
    private String departamento;
}

//sin Password, fechaIngreso, fechaNacimiento 
// Perfil y Departamento son String en lugar de objetos para no tener que enviar TODO