package com.cursojva.cursoSpring.negocio;

import com.cursojva.cursoSpring.dto.UsuarioDto;
import com.cursojva.cursoSpring.dto.VentaDto;
import com.cursojva.cursoSpring.entities.Usuario;
import com.cursojva.cursoSpring.entities.Venta;
import com.cursojva.cursoSpring.implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VentaNegocio {

    @Autowired
    private VentaImpl ventaImpl;

    private List<VentaDto> listVentaDto;
    public List<VentaDto> encontrarTodos(){
        listVentaDto = new ArrayList<>();
        this.ventaImpl.encontrarTodos().forEach(venta -> {

            VentaDto ventaDto = new VentaDto();
            ventaDto.setIdVenta(venta.getIdVenta());
            ventaDto.setFechaVenta(venta.getFechaVenta());
            ventaDto.setPrecioFinal(venta.getPrecioFinal());
            ventaDto.setObservaciones(venta.getObservaciones());
            ventaDto.setVehiculos(venta.getVehiculos());
            ventaDto.setUsuarios(ventaDto.getUsuarios());
            this.listVentaDto.add(ventaDto);
        });
        return this.listVentaDto;
    }

    public String guardarVenta(VentaDto ventaDto) {

        Venta venta = new Venta();

        try {
            if (ventaDto.getIdVenta() != 0) {
                venta.setIdVenta(ventaDto.getIdVenta());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setPrecioFinal(ventaDto.getPrecioFinal());
                venta.setObservaciones(ventaDto.getObservaciones());
                venta.setVehiculos(ventaDto.getVehiculos());
                venta.setUsuarios(ventaDto.getUsuarios());
                this.ventaImpl.actualizarUsuario(venta);
            } else {
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setPrecioFinal(ventaDto.getPrecioFinal());
                venta.setObservaciones(ventaDto.getObservaciones());
                venta.setVehiculos(ventaDto.getVehiculos());
                venta.setUsuarios(ventaDto.getUsuarios());
                this.ventaImpl.crearUsuario(venta);
            }
            return "OK";
        }catch (Exception e){
            return "BAD";
        }
    }
}
