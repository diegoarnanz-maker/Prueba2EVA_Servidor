package proyectos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Departamento;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
