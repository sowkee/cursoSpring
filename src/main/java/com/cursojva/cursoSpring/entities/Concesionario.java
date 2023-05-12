package com.cursojva.cursoSpring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "concesionarios")
@Data
public class Concesionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConcesionario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idConcesionario")
    private List<Vehiculo> vehiculos;
}
