package proyectos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.entity.Proyecto;
import proyectos.modelo.repository.IProyectoRepository;

@Service
public class ProyectoServiceImplMy8 extends GenericoCRUDServiceImplMy8<Proyecto, String> implements IProyectoService {

    @Autowired
    private IProyectoRepository proyectoRepository;

    @Override
    protected IProyectoRepository getRepository() {
        return proyectoRepository;
    }

}
