package proyectos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.entity.Perfil;
import proyectos.modelo.repository.IPerfilRepository;

@Service
public class PerfilServiceImplMy8 extends GenericoCRUDServiceImplMy8<Perfil, Integer> implements IPerfilService {

    @Autowired
    private IPerfilRepository perfilRepository;

    @Override
    protected IPerfilRepository getRepository() {
        return perfilRepository;
    }

}
