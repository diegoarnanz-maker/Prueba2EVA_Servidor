package proyectos.modelo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDTO {
    private String idFactura;
    private String descripcion;
    private String idProyecto;
}

// idProyecyo String en vez de objeto Proyecto