package com.cursojva.cursoSpring.service;

import com.cursojva.cursoSpring.entities.Vehiculo;

import java.util.List;

public interface VehiculoService {
    public List<Vehiculo> encontrarTodos();

    public Vehiculo encontrarPorId(int id);

    public void crearVehiculo(Vehiculo vehiculo);

    public void actualizarVehiculo(Vehiculo vehiculo);

    public void eliminarVehiculo(int id);
}
