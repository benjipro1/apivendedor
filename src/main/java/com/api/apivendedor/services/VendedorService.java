package com.api.apivendedor.services;

import com.api.apivendedor.models.Vendedor;
import com.api.apivendedor.dto.VendedorDTO;
import com.api.apivendedor.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    private VendedorDTO toDTO(Vendedor vendedor) {
        return new VendedorDTO(
            vendedor.getIdVendedor(),
            vendedor.getNombre(),
            vendedor.getApellido(),
            vendedor.getSucursalAsignada(),
            vendedor.getMeta(),
            vendedor.isMetaCumplida()
        );
    }

    private Vendedor toEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(vendedorDTO.getIdVendedor());
        vendedor.setNombre(vendedorDTO.getNombre());
        vendedor.setApellido(vendedorDTO.getApellido());
        vendedor.setSucursalAsignada(vendedorDTO.getSucursalAsignada());
        vendedor.setMeta(vendedorDTO.getMeta());
        vendedor.setMetaCumplida(vendedorDTO.isMetaCumplida());
        return vendedor;
    }

    public VendedorDTO crear(VendedorDTO vendedorDTO) {
        Vendedor vendedor = toEntity(vendedorDTO);
        Vendedor savedVendedor = vendedorRepository.save(vendedor);
        return toDTO(savedVendedor);
    }

    public List<VendedorDTO> listar() {
        return vendedorRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public VendedorDTO buscarPorId(Integer id) {
        Vendedor vendedor = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con ID: " + id));
        return toDTO(vendedor);
    }

    public VendedorDTO actualizar(Integer id, VendedorDTO vendedorDTO) {
        Vendedor vendedorExistente = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con ID: " + id));
        
        vendedorExistente.setNombre(vendedorDTO.getNombre());
        vendedorExistente.setApellido(vendedorDTO.getApellido());
        vendedorExistente.setSucursalAsignada(vendedorDTO.getSucursalAsignada());
        vendedorExistente.setMeta(vendedorDTO.getMeta());
        vendedorExistente.setMetaCumplida(vendedorDTO.isMetaCumplida());

        return toDTO(vendedorRepository.save(vendedorExistente));
    }

    public void eliminar(Integer id) {
        vendedorRepository.deleteById(id);
    }
    
}
