package com.cursojva.cursoSpring.dto;

import com.cursojva.cursoSpring.entities.Vehiculo;
import lombok.Data;

import java.util.List;

@Data
public class ConcesionarioDto {
    private int idConcesionario;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    private List<Vehiculo> vehiculos;
}
