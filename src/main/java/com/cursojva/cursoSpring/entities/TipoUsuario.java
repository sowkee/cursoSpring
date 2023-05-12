package com.cursojva.cursoSpring.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "tipo_usuarios")
@Data
public class TipoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoUsuario;

    @Column(name = "empleados", length = 11)
    private String empleado;

    @Column(name = "clientes", length = 11)
    private String cliente;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario fk_idUsuario;

}
