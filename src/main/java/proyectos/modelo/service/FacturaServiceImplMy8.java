package proyectos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.entity.Factura;
import proyectos.modelo.repository.IFacturaRepository;

@Service
public class FacturaServiceImplMy8 extends GenericoCRUDServiceImplMy8<Factura, String> implements IFacturaService {

    @Autowired
    private IFacturaRepository facturaRepository;

    @Override
    protected IFacturaRepository getRepository() {
        return facturaRepository;
    }

}
