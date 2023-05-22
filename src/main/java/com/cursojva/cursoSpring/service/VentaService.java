package com.cursojva.cursoSpring.service;

import com.cursojva.cursoSpring.entities.Venta;

import java.util.List;

public interface VentaService {
    public List<Venta> encontrarTodos();

    public Venta encontrarPorId(int id);

    public void crearVenta(Venta venta);

    public void actualizarVenta(Venta venta);

    public void eliminarVenta(int id);
}
