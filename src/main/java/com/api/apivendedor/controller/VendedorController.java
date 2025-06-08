package com.api.apivendedor.controller;

import com.api.apivendedor.dto.VendedorDTO;
import com.api.apivendedor.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

}
