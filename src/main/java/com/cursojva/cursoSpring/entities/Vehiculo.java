package com.cursojva.cursoSpring.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "vehiculos")
@Data
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVehiculos;

    @Column(name = "kilometraje")
     int kilometraje;

    @Column(name = "matricula")
     String matricula;

    @Column(name = "marca")
     String marca;

    @Column(name = "modelo")
     String modelo;

    @Column(name = "color")
     String color;

    @Column(name = "precio")
     int precio;

    @ManyToOne
    @JoinColumn(name = "idConcesionario")
    Concesionario fk_idConcesionario;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    Venta fk_idVenta;



}
