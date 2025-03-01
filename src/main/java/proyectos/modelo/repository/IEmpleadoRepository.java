package proyectos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
