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

import proyectos.modelo.dto.EmpleadoDTO;
import proyectos.modelo.service.IEmpleadoService;

@RestController
@RequestMapping("api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadosRestController {

    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados() {
        List<EmpleadoDTO> empleadosDto = empleadoService.findAll()
                .stream()
                .map(empleado -> {
                    EmpleadoDTO dto = modelMapper.map(empleado, EmpleadoDTO.class);
                    dto.setPerfil(empleado.getPerfil().getNombre());
                    dto.setDepartamento(empleado.getDepartamento().getNombre());
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(empleadosDto);
    }

}
