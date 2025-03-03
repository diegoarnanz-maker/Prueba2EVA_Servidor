package proyectos.restcontroller;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import proyectos.modelo.dto.FacturaDTO;
import proyectos.modelo.entity.Factura;
import proyectos.modelo.service.IFacturaService;

@RestController
@RequestMapping("api/facturas")
@CrossOrigin(origins = "*")
public class FacturaRestController {

    @Autowired
    private IFacturaService facturaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> listarFacturas() {
        List<FacturaDTO> facturaDTO = facturaService.findAll()
                .stream()
                .map(factura -> modelMapper.map(factura, FacturaDTO.class))
                .toList();
        return ResponseEntity.ok(facturaDTO);
    }

    @GetMapping("/{idFactura}")
    public ResponseEntity<FacturaDTO> read(@PathVariable String idFactura) {
        FacturaDTO facturaDTO = modelMapper.map(facturaService.read(idFactura),
                FacturaDTO.class);
        return ResponseEntity.ok(facturaDTO);

    }

    @PostMapping
    public ResponseEntity<FacturaDTO> create(@RequestBody FacturaDTO facturaDTO) {
        Factura factura = modelMapper.map(facturaDTO, Factura.class);
        facturaService.create(factura);
        return ResponseEntity.ok(facturaDTO);
    }

    @PutMapping("/{idFactura}")
    public ResponseEntity<FacturaDTO> update(@PathVariable String idFactura, @RequestBody FacturaDTO facturaDTO) {
        Factura factura = modelMapper.map(facturaDTO, Factura.class);
        facturaService.update(factura);
        return ResponseEntity.ok(facturaDTO);
    }

    @DeleteMapping("/{idFactura}")
    public ResponseEntity<Void> delete(@PathVariable String idFactura) {
        facturaService.delete(idFactura);
        return ResponseEntity.noContent().build();
    }
}
