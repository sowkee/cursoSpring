package com.cursojva.cursoSpring.service;

import com.cursojva.cursoSpring.entities.Usuario;
import com.cursojva.cursoSpring.entities.Vehiculo;

import java.util.List;

public interface VehiculoService {
    public List<Vehiculo> encontrarTodos();

    public Vehiculo encontrarPorId(int id);

    public void crearUsuario(Vehiculo vehiculo);

    public void actualizarUsuario(Vehiculo vehiculo);

    public void eliminarUsuario(int id);
}
