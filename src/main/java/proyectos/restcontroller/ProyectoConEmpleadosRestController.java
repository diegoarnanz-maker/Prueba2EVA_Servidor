package proyectos.restcontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import proyectos.modelo.dto.ProyectoConEmpleadosDTO;
import proyectos.modelo.entity.Empleado;
import proyectos.modelo.entity.Proyecto;
import proyectos.modelo.entity.ProyectoConEmpleados;
import proyectos.modelo.service.IEmpleadoService;
import proyectos.modelo.service.IProyectoConEmpleadosService;
import proyectos.modelo.service.IProyectoService;

@RestController
@RequestMapping("api/proyectos-con-empleados")
@CrossOrigin(origins = "*")
public class ProyectoConEmpleadosRestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProyectoConEmpleadosService proyectoConEmpleadosService;

    @Autowired
    private IProyectoService proyectoService;

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<ProyectoConEmpleadosDTO>> findAll() {
        return ResponseEntity.ok(proyectoConEmpleadosService.findAll().stream()
                .map(proyectoConEmpleados -> modelMapper.map(proyectoConEmpleados, ProyectoConEmpleadosDTO.class))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{numeroOrden}")
    public ResponseEntity<ProyectoConEmpleadosDTO> findById(@PathVariable int numeroOrden) {
        return ResponseEntity.ok(
                modelMapper.map(proyectoConEmpleadosService.read(numeroOrden).get(), ProyectoConEmpleadosDTO.class));
    }

    @PostMapping
    public ResponseEntity<ProyectoConEmpleadosDTO> create(@RequestBody ProyectoConEmpleadosDTO dto) {
        // 📌 Verificar si el Proyecto existe
        Proyecto proyecto = proyectoService.read(dto.getIdProyecto())
                .orElseThrow(() -> new RuntimeException("No se encontró el Proyecto con ID: " + dto.getIdProyecto()));

        // 📌 Verificar si el Empleado existe
        Empleado empleado = empleadoService.read(dto.getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("No se encontró el Empleado con ID: " + dto.getIdEmpleado()));

        // 📌 Convertir DTO a entidad
        ProyectoConEmpleados proyectoConEmpleados = new ProyectoConEmpleados();
        proyectoConEmpleados.setProyecto(proyecto);
        proyectoConEmpleados.setEmpleado(empleado);
        proyectoConEmpleados.setHorasAsignadas(dto.getHorasAsignadas());
        proyectoConEmpleados.setFechaIncorporacion(LocalDate.parse(dto.getFechaIncorporacion()));

        // 📌 Guardar en la base de datos
        ProyectoConEmpleados guardado = proyectoConEmpleadosService.create(proyectoConEmpleados);

        // 📌 Convertir de nuevo a DTO para la respuesta
        ProyectoConEmpleadosDTO responseDTO = new ProyectoConEmpleadosDTO();
        responseDTO.setNumeroOrden(guardado.getNumeroOrden());
        responseDTO.setIdProyecto(guardado.getProyecto().getIdProyecto());
        responseDTO.setNombreProyecto(guardado.getProyecto().getDescripcion());
        responseDTO.setIdEmpleado(guardado.getEmpleado().getIdEmpl());
        responseDTO.setNombreEmpleado(guardado.getEmpleado().getNombre());
        responseDTO.setHorasAsignadas(guardado.getHorasAsignadas());
        responseDTO.setFechaIncorporacion(guardado.getFechaIncorporacion().toString());

        return ResponseEntity.ok(responseDTO);
    }

}
