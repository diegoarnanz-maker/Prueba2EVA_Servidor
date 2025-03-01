package proyectos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.entity.ProyectoConEmpleados;
import proyectos.modelo.repository.IProyectoConEmpleadosRepository;

@Service
public class ProyectoConEmpleadosServiceImplMy8 extends GenericoCRUDServiceImplMy8<ProyectoConEmpleados, Integer> implements IProyectoConEmpleadosService {

    @Autowired
    private IProyectoConEmpleadosRepository proyectoConEmpleadosRepository;

    @Override
    protected IProyectoConEmpleadosRepository getRepository() {
        return (IProyectoConEmpleadosRepository) proyectoConEmpleadosRepository;
    }

}
