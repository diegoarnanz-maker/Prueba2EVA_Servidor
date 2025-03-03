package proyectos.restcontroller;

import java.util.List;
import java.util.Optional;

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

import proyectos.modelo.entity.Perfil;
import proyectos.modelo.service.IPerfilService;

@RestController
@RequestMapping("api/perfiles")
@CrossOrigin(origins = "*")
public class PerfilRestcontroller {

    @Autowired
    private IPerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Perfil>> findAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }

    @GetMapping("/{idPerfil}")
    public ResponseEntity<Optional<Perfil>> findById(@PathVariable int idPerfil) {
        return ResponseEntity.ok(perfilService.read(idPerfil));
    }

    @PostMapping
    public ResponseEntity<Perfil> create(@RequestBody Perfil perfil) {
        perfilService.create(perfil);
        return ResponseEntity.ok(perfil);
    }

    @PutMapping("/{idPerfil}")
    public ResponseEntity<Perfil> update(@PathVariable int idPerfil, @RequestBody Perfil perfil) {
        Optional<Perfil> perfilExistente = perfilService.read(idPerfil);

        if (perfilExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        perfil.setIdPerfil(idPerfil);

        Perfil perfilActualizado = perfilService.update(perfil);

        return ResponseEntity.ok(perfilActualizado);
    }

    @DeleteMapping("/{idPerfil}")
    public ResponseEntity<Void> delete(@PathVariable int idPerfil) {
        perfilService.delete(idPerfil);
        return ResponseEntity.noContent().build();
    }

}
