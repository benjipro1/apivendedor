package com.api.apivendedor.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendedorDTO {
    private int idVendedor;
    private String nombre;
    private String apellido;
    private String sucursalAsignada;
    private int meta;
    private boolean metaCumplida;
}
