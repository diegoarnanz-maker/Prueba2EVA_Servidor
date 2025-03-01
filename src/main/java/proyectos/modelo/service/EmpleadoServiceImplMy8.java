package proyectos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.entity.Empleado;
import proyectos.modelo.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImplMy8 extends GenericoCRUDServiceImplMy8<Empleado, Integer> implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    protected IEmpleadoRepository getRepository() {
        return empleadoRepository;
    }

}
