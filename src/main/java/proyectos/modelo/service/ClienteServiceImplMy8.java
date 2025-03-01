package proyectos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.entity.Cliente;
import proyectos.modelo.repository.IClienteRepository;

@Service
public class ClienteServiceImplMy8 extends GenericoCRUDServiceImplMy8<Cliente, String> implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    protected IClienteRepository getRepository() {
        return clienteRepository;
    }

}
