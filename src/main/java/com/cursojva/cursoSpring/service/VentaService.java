package com.cursojva.cursoSpring.service;

import com.cursojva.cursoSpring.entities.Usuario;
import com.cursojva.cursoSpring.entities.Vehiculo;
import com.cursojva.cursoSpring.entities.Venta;

import java.util.List;

public interface VentaService {
    public List<Venta> encontrarTodos();

    public Venta encontrarPorId(int id);

    public void crearUsuario(Venta venta);

    public void actualizarUsuario(Venta venta);

    public void eliminarUsuario(int id);
}
