package com.cursojva.cursoSpring.implementacion;

import com.cursojva.cursoSpring.entities.Venta;
import com.cursojva.cursoSpring.repository.VentaRepository;
import com.cursojva.cursoSpring.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaService {


    @Autowired
    VentaRepository ventaRepository;

    @Override
    public List<Venta> encontrarTodos() {

        return this.ventaRepository.findAll();
    }

    @Override
    public Venta encontrarPorId(int id) {

        return this.ventaRepository.encontrarPorId(id);
    }

    @Override
    public void crearVenta(Venta venta) {

        this.ventaRepository.save(venta);
    }

    @Override
    public void actualizarVenta(Venta venta) {

        this.ventaRepository.save(venta);
    }

    @Override
    public void eliminarVenta(int id) {
        System.out.println("####" + id);
        Venta venta = this.ventaRepository.getById(id);
        System.out.println("@@@@" + venta.toString());

        if(venta != null) {
            this.ventaRepository.delete(venta);
        }


    }
}
