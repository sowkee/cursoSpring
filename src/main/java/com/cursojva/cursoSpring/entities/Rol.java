package com.cursojva.cursoSpring.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;



}
