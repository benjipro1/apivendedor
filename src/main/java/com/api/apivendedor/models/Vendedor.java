package com.api.apivendedor.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vendedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private int idVendedor;

    private String nombre;
    private String apellido;
    
    @Column(name = "sucursal_Asignada")
    private String sucursalAsignada;

    @Column(name = "meta_venta_mes")
    private int meta;
    private boolean metaCumplida;

}
