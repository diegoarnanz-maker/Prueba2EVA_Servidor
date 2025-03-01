package proyectos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, String> {

}
