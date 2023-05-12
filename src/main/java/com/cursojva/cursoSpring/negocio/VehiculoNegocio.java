package com.cursojva.cursoSpring.negocio;

import com.cursojva.cursoSpring.dto.VehiculoDto;
import com.cursojva.cursoSpring.entities.Vehiculo;
import com.cursojva.cursoSpring.implementacion.VehiculoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoNegocio {
    @Autowired
    private VehiculoImpl vehiculoImpl;

    private List<VehiculoDto> listVehiculoDto;

    public List<VehiculoDto> encontrarTodos() {
        listVehiculoDto = new ArrayList<>();

        this.vehiculoImpl.encontrarTodos().forEach(vehiculo -> {
            VehiculoDto vehiculoDto = new VehiculoDto();
            vehiculoDto.setIdVehiculos(vehiculo.getIdVehiculos());
            vehiculoDto.setKilometraje(vehiculo.getKilometraje());
            vehiculoDto.setMatricula(vehiculo.getMatricula());
            vehiculoDto.setMarca(vehiculo.getMarca());
            vehiculoDto.setModelo(vehiculo.getModelo());
            vehiculoDto.setColor(vehiculo.getColor());
            vehiculoDto.setPrecio(vehiculo.getPrecio());
            this.listVehiculoDto.add(vehiculoDto);
        });
        return this.listVehiculoDto;

    }

    public String guardarVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = new Vehiculo();
         try {
             if(vehiculoDto.getIdVehiculos() != 0) {
                 vehiculo.setIdVehiculos(vehiculoDto.getIdVehiculos());
                 vehiculo.setKilometraje(vehiculoDto.getKilometraje());
                 vehiculo.setMatricula(vehiculoDto.getMatricula());
                 vehiculo.setMarca(vehiculoDto.getMarca());
                 vehiculo.setModelo(vehiculoDto.getModelo());
                 vehiculo.setColor(vehiculoDto.getColor());
                 vehiculo.setPrecio(vehiculoDto.getPrecio());
                 this.vehiculoImpl.actualizarUsuario(vehiculo);
             }else {

                 vehiculo.setKilometraje(vehiculoDto.getKilometraje());
                 vehiculo.setMatricula(vehiculoDto.getMatricula());
                 vehiculo.setMarca(vehiculoDto.getMarca());
                 vehiculo.setModelo(vehiculoDto.getModelo());
                 vehiculo.setColor(vehiculoDto.getColor());
                 vehiculo.setPrecio(vehiculoDto.getPrecio());
                 this.vehiculoImpl.crearUsuario(vehiculo);
             }
             return "OK.";
         }catch (Exception e) {
             return "BAD.";
         }

    }
}
