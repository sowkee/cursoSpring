package com.cursojva.cursoSpring.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;

@Data
@Component
public class UsuarioDto {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private int identificacion;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private String telefono;
    private String direccion;
    private String password;
}
