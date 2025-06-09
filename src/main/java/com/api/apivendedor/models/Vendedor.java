package com.api.apivendedor.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vendedores")
@Data
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVendedor;

    private String nombre;
    private String apellido;
    private String sucursalAsignada;
    private int meta;
    private boolean metaCumplida;

}
