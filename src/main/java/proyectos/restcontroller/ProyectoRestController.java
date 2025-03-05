package proyectos.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.modelo.dto.ProyectoDTO;
import proyectos.modelo.dto_examen.FacturaDTOExamen;
import proyectos.modelo.entity.EstadoProyecto;
import proyectos.modelo.entity.Proyecto;
import proyectos.modelo.service.IFacturaService;
import proyectos.modelo.service.IProyectoService;

@RestController
@RequestMapping("api/proyectos")
@CrossOrigin(origins = "*")
public class ProyectoRestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProyectoService proyectoService;

    @Autowired
    private IFacturaService facturaService;

    //Lo he hecho devolviendo una lista de facturas porque un proyecto puede tener varias facturas por la relacion que tiene en la bbdd
    @GetMapping("/factura/{idProyecto}")
    public ResponseEntity<List<FacturaDTOExamen>> readFacturaByIdProyecto(@PathVariable String idProyecto) {
        return ResponseEntity.ok(facturaService.ObtenerFacturaDTOExamen(idProyecto));
    }

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

    @GetMapping("/{idProyecto}")
    public ResponseEntity<ProyectoDTO> buscarProyectoPorId(@PathVariable String idProyecto) {
        ProyectoDTO proyectoDto = modelMapper.map(proyectoService.read(idProyecto).get(), ProyectoDTO.class);
        proyectoDto.setJefeProyecto(proyectoService.read(idProyecto).get().getJefeProyecto().getNombre());
        proyectoDto.setCliente(proyectoService.read(idProyecto).get().getCliente().getNombre());
        return ResponseEntity.ok(proyectoDto);
    }

    @PostMapping
    public ResponseEntity<ProyectoDTO> crearProyecto(@RequestBody ProyectoDTO proyectoDto) {
        Proyecto proyecto = modelMapper.map(proyectoDto, Proyecto.class);

        // Hay varias formas de asignar este valor como ACTIVO:
        // 1. En la entidad con @PrePersist
        // 2. En el servicio antes de llamar a create, pero al ser generico no quiero
        // 3. Aquí mismo antes de convertir el DTO a entidad
        if (proyecto.getEstado() == null) {
            proyecto.setEstado(EstadoProyecto.ACTIVO);
        }

        Proyecto proyectoCreado = proyectoService.create(proyecto);

        ProyectoDTO responseDto = modelMapper.map(proyectoCreado, ProyectoDTO.class);

        responseDto.setJefeProyecto(proyectoCreado.getJefeProyecto().getNombre());
        responseDto.setCliente(proyectoCreado.getCliente().getNombre());

        return ResponseEntity.ok(responseDto);
    }

}
