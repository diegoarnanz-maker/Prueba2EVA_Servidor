package proyectos.modelo.service;

import proyectos.modelo.entity.Empleado;

public interface IEmpleadoService extends IGenericoCRUD<Empleado, Integer> {

    String obtenerNombreCompleto(Empleado empleado);
}
