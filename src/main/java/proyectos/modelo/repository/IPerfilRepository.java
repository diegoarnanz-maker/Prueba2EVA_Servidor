package proyectos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Perfil;

public interface IPerfilRepository extends JpaRepository<Perfil, Integer> {

}
