package proyectos.modelo.service;

import java.util.List;

import proyectos.modelo.entity.ProyectoConEmpleados;

public interface IProyectoConEmpleadosService extends IGenericoCRUD<ProyectoConEmpleados, Integer> {

    List<ProyectoConEmpleados> findByProyectoId(String idProyecto);

}
