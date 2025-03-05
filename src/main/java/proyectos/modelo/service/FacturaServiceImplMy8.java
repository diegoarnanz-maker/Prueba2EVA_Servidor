package proyectos.modelo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.dto_examen.ClienteDTOExamen;
import proyectos.modelo.dto_examen.EmpleadoDTOExamen;
import proyectos.modelo.dto_examen.FacturaDTOExamen;
import proyectos.modelo.dto_examen.ProyectoDTOExamen;
import proyectos.modelo.entity.Empleado;
import proyectos.modelo.entity.Factura;
import proyectos.modelo.entity.Proyecto;
import proyectos.modelo.entity.ProyectoConEmpleados;
import proyectos.modelo.repository.IFacturaRepository;

@Service
public class FacturaServiceImplMy8 extends GenericoCRUDServiceImplMy8<Factura, String> implements IFacturaService {

    @Autowired
    private IFacturaRepository facturaRepository;

    @Autowired
    private IProyectoService proyectoService;

    @Autowired
    private IProyectoConEmpleadosService proyectoConEmpleadosService;

    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected IFacturaRepository getRepository() {
        return facturaRepository;
    }

    @Override
    public List<FacturaDTOExamen> ObtenerFacturaDTOExamen(String idProyecto) {
        // Obtener entidades Proyecto y Factura enteras
        Proyecto proyecto = proyectoService.read(idProyecto)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado: " + idProyecto));

        List<Factura> facturas = facturaRepository.findByProyectoId(idProyecto);
        if (facturas.isEmpty()) {
            throw new RuntimeException("Minguna factura no encontrada para el proyecto: " + idProyecto);
        }

        // Obtener los empleados asignados al proyecto
        List<ProyectoConEmpleados> proyectoConEmpleados = proyectoConEmpleadosService.findByProyectoId(idProyecto);

        // Mapear Cliente y Proyecto con ModelMapper, so podria hacer manual con
        // builder()
        ClienteDTOExamen clienteDto = modelMapper.map(proyecto.getCliente(), ClienteDTOExamen.class);
        ProyectoDTOExamen proyectoDto = modelMapper.map(proyecto, ProyectoDTOExamen.class);

        // Mapear lista de empleados
        List<EmpleadoDTOExamen> detalleEmpleados = proyectoConEmpleados.stream()
                .map(asignacion -> {
                    Empleado empleado = asignacion.getEmpleado();
                    int horasAsignadas = asignacion.getHorasAsignadas();
                    double precioHora = empleado.getSalario() / 1800;
                    double importeRepercutido = precioHora * horasAsignadas;

                    return EmpleadoDTOExamen.builder()
                            .apellidoYNombre(empleadoService.obtenerNombreCompleto(empleado))
                            .horasTotales(horasAsignadas)
                            .importeRepercutido(importeRepercutido)
                            .build();
                }).collect(Collectors.toList());

        // Calcular total de horas e importe facturado de cada empleado
        int totalHoras = detalleEmpleados.stream().mapToInt(EmpleadoDTOExamen::getHorasTotales).sum();
        double totalFacturado = detalleEmpleados.stream().mapToDouble(EmpleadoDTOExamen::getImporteRepercutido).sum();

        // Mapear FacturaDTOExamen para mostrar en el json de respuesta lo que requiere el cliente
        List<FacturaDTOExamen> facturasDTO = facturas.stream().map(factura -> {
            FacturaDTOExamen facturaDTO = modelMapper.map(factura, FacturaDTOExamen.class);
            facturaDTO.setFechaFactura(LocalDate.now());
            facturaDTO.setCliente(clienteDto);
            facturaDTO.setProyecto(proyectoDto);
            facturaDTO.setDetalleEmpleado(detalleEmpleados);
            facturaDTO.setTotalHoras(totalHoras);
            facturaDTO.setVentaPrevisto(proyecto.getVentaPrevisto());
            facturaDTO.setTotalFacturado(totalFacturado);
            return facturaDTO;
        }).collect(Collectors.toList());

        return facturasDTO;
    }

}
