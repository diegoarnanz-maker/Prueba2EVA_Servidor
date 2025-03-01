package proyectos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Proyecto;

public interface IProyectoRepository extends JpaRepository<Proyecto, String> {

}
