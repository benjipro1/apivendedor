package com.api.apivendedor.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
public class VendedorDTO extends RepresentationModel<VendedorDTO> {
    private int idVendedor;
    private String nombre;
    private String apellido;
    private String sucursalAsignada;
    private int meta;
    private boolean metaCumplida;
}
