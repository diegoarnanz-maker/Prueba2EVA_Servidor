package proyectos.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.modelo.dto.ProyectoDTO;
import proyectos.modelo.service.IProyectoService;

@RestController
@RequestMapping("api/proyectos")
@CrossOrigin(origins = "*")
public class ProyectosRestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> listarProyectos() {
        List<ProyectoDTO> proyectosDto = proyectoService.findAll()
                .stream()
                .map(proyecto -> {
                    ProyectoDTO dto = modelMapper.map(proyecto, ProyectoDTO.class);
                    dto.setJefeProyecto(proyecto.getJefeProyecto().getNombre());
                    dto.setCliente(proyecto.getCliente().getNombre());
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(proyectosDto);
    }

}
