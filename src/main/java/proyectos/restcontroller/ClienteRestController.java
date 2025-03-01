package proyectos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.modelo.entity.Cliente;
import proyectos.modelo.service.IClienteService;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin(origins = "*")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{cif}")
    public ResponseEntity<Cliente> buscarClientePorCif(@PathVariable String cif) {
        return ResponseEntity.ok(clienteService.read(cif).get());
    }

    @PostMapping()
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.create(cliente));
    }

    @PutMapping("/{cif}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable String cif, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.update(cliente));
    }

    @DeleteMapping("/{cif}")
    public ResponseEntity<Void> borrarCliente(@PathVariable String cif) {
        clienteService.delete(cif);
        return ResponseEntity.noContent().build();
    }
}
