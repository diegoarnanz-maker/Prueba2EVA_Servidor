package proyectos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.modelo.entity.Departamento;
import proyectos.modelo.service.IDepartamentoService;

@RestController
@RequestMapping("api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoRestController {

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        return ResponseEntity.ok(departamentoService.findAll());
    }

    @GetMapping("/{idDepartamento}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable int idDepartamento) {
        return ResponseEntity.ok(departamentoService.read(idDepartamento).get());
    }

    @PostMapping
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento departamento) {
        return ResponseEntity.ok(departamentoService.create(departamento));
    }

    @PutMapping("/{idDepartamento}")
    public ResponseEntity<Departamento> actualizarDepartamento(@PathVariable int idDepartamento, @RequestBody Departamento departamento) {
        return ResponseEntity.ok(departamentoService.update(departamento));
    }

}
