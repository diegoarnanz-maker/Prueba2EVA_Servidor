package proyectos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.ProyectoConEmpleados;

public interface IProyectoConEmpleadosRepository extends JpaRepository<ProyectoConEmpleados, Integer> {

}
