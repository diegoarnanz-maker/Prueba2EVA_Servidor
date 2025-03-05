package proyectos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyectos.modelo.entity.ProyectoConEmpleados;

public interface IProyectoConEmpleadosRepository extends JpaRepository<ProyectoConEmpleados, Integer> {

    @Query("SELECT pce FROM ProyectoConEmpleados pce WHERE pce.proyecto.idProyecto = :idProyecto")
    List<ProyectoConEmpleados> findByProyectoId(@Param("idProyecto") String idProyecto);

}
