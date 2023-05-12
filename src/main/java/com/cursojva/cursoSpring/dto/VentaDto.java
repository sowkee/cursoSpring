package com.cursojva.cursoSpring.dto;

import com.cursojva.cursoSpring.entities.Usuario;
import com.cursojva.cursoSpring.entities.Vehiculo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Component
public class VentaDto {
    int idVenta;
    Date fechaVenta;
    int precioFinal;
    private List<Vehiculo> vehiculos;
    private List<Usuario> usuarios;
    String observaciones;

}
