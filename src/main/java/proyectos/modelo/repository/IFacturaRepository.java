package proyectos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import proyectos.modelo.entity.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, String> {

    @Query("SELECT f FROM Factura f WHERE f.proyecto.idProyecto = :idProyecto")
    List<Factura> findByProyectoId(@Param("idProyecto") String idProyecto);

}
