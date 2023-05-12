package com.cursojva.cursoSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVenta;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaVenta")
    Date fechaVenta;
    @Column(name = "precioFinal")
    int precioFinal;
    @Column(name = "observaciones")
    String observaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idVenta")
    private List<Vehiculo> vehiculos;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idVenta")
    private List<Usuario> usuarios;


}
