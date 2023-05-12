package com.cursojva.cursoSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "apellido")
    String apellido;
    @Column(name = "correo")
    String correo;
    @Column(name = "identificacion", nullable = false)
    int identificacion;

    @Column(name = "fechaNacimiento")
    Date fechaNacimiento;

    @Column(name = "fechaIngreso")
    Date fechaIngreso;
    @Column(name = "telefono")
    String telefono;
    @Column(name = "direccion")
    String direccion;
    @Column(name = "password")
    String password;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta fk_idVenta;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idUsuario")
    private List<TipoUsuario> tipoUsuarios;

    @ManyToMany
    @JoinTable(name = "usuarios_has_roles",
    joinColumns = @JoinColumn(name = "fk_idRol", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "fk_idUsuario", nullable = false))
    private List<Rol>listRoles;







}
