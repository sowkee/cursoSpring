package com.cursojva.cursoSpring.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class VehiculoDto {

    int idVehiculos;

    int kilometraje;

    String matricula;

    String marca;

    String modelo;

    String color;

    int precio;

}
