package com.cursojva.cursoSpring.negocio;

import com.cursojva.cursoSpring.dto.ConcesionarioDto;
import com.cursojva.cursoSpring.entities.Concesionario;
import com.cursojva.cursoSpring.implementacion.ConcesionarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcesionarioNegocio {

    @Autowired
    private ConcesionarioImpl concesionarioImpl;

    public List<ConcesionarioDto> listConcesionarioDto;

    public List<ConcesionarioDto> encontrarTodos(){
        listConcesionarioDto = new ArrayList<>();
        this.concesionarioImpl.encontrarTodos().forEach(concesionario -> {

            ConcesionarioDto concesionarioDto = new ConcesionarioDto();

            concesionarioDto.setIdConcesionario(concesionario.getIdConcesionario());
            concesionarioDto.setNombre(concesionario.getNombre());
            concesionarioDto.setCorreo(concesionario.getCorreo());
            concesionarioDto.setTelefono(concesionario.getTelefono());
            concesionarioDto.setDireccion(concesionario.getDireccion());
            concesionarioDto.setVehiculos(concesionario.getVehiculos());

            this.listConcesionarioDto.add(concesionarioDto);
        });
        return this.listConcesionarioDto;
    }

    public String guardarConcesionario(ConcesionarioDto concesionarioDto) {
        Concesionario concesionario = new Concesionario();
        try {
            if (concesionarioDto.getIdConcesionario() != 0) {
                concesionario.setIdConcesionario(concesionarioDto.getIdConcesionario());
                concesionario.setNombre(concesionarioDto.getNombre());
                concesionario.setCorreo(concesionarioDto.getCorreo());
                concesionario.setTelefono(concesionarioDto.getTelefono());
                concesionario.setDireccion(concesionarioDto.getDireccion());
                concesionario.setVehiculos(concesionarioDto.getVehiculos());

                this.concesionarioImpl.actualizarConcesionario(concesionario);
            } else {

                concesionario.setNombre(concesionarioDto.getNombre());
                concesionario.setCorreo(concesionarioDto.getCorreo());
                concesionario.setTelefono(concesionarioDto.getTelefono());
                concesionario.setDireccion(concesionarioDto.getDireccion());
                concesionario.setVehiculos(concesionarioDto.getVehiculos());

                this.concesionarioImpl.crearConcesionario(concesionario);
            }
            return "OK";
        }catch (Exception e){
            return "BAD";
        }
    }

    public String eliminar (int id) {
        Concesionario concesionario;
        try{
            this.concesionarioImpl.eliminarConcesionario(id);
            return "OK";
        }catch (Exception e) {
            e.printStackTrace();
            return "BAD";
        }
    }
}
