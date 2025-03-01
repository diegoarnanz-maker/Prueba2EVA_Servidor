package proyectos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.entity.Departamento;
import proyectos.modelo.repository.IDepartamentoRepository;

@Service
public class DepartamentoServiceImplMy8 extends GenericoCRUDServiceImplMy8<Departamento, Integer> implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    protected IDepartamentoRepository getRepository() {
        return departamentoRepository;
    }

}
