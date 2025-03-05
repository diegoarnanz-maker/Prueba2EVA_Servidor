package proyectos.modelo.service;

import java.util.List;

import proyectos.modelo.dto_examen.FacturaDTOExamen;
import proyectos.modelo.entity.Factura;

public interface IFacturaService extends IGenericoCRUD<Factura, String> {

    List<FacturaDTOExamen> ObtenerFacturaDTOExamen(String idProyecto);
}
