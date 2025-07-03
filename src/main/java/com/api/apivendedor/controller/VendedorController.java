package com.api.apivendedor.controller;

import com.api.apivendedor.dto.VendedorDTO;
import com.api.apivendedor.models.Vendedor;
import com.api.apivendedor.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<VendedorDTO> crear(@RequestBody VendedorDTO vendedorDTO) {
        return ResponseEntity.ok(vendedorService.crear(vendedorDTO));
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> listar() {
        return ResponseEntity.ok(vendedorService.listar());
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(vendedorService.buscarPorId(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> actualizar(@PathVariable Integer id, @RequestBody VendedorDTO vendedorDTO) {
        return ResponseEntity.ok(vendedorService.actualizar(id, vendedorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        vendedorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public VendedorDTO obtenerHateoas(@PathVariable Integer id) {
        VendedorDTO dto = vendedorService.buscarPorId(id);
        dto.add(linkTo(methodOn(VendedorController.class).obtenerHateoas(id)).withSelfRel());
        dto.add(linkTo(methodOn(VendedorController.class).listarHateoas()).withRel("TODOS"));
        dto.add(linkTo(methodOn(VendedorController.class).eliminar(id)).withRel("ELIMINAR"));
        return dto;
    }

    @GetMapping("/hateoas")
    public List<VendedorDTO> listarHateoas() {
        List<VendedorDTO> vendedor = vendedorService.listar();
        for (VendedorDTO dto : vendedor) {
            dto.add(linkTo(methodOn(VendedorController.class).obtenerHateoas(dto.getIdVendedor())).withSelfRel());
        }
        return vendedor;
    }
}
