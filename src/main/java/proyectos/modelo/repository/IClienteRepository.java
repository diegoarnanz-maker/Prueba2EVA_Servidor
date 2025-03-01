package proyectos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, String>{

}
