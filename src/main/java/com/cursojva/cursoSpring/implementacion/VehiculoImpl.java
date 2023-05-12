package com.cursojva.cursoSpring.implementacion;

import com.cursojva.cursoSpring.entities.Vehiculo;
import com.cursojva.cursoSpring.repository.VehiculoRepository;
import com.cursojva.cursoSpring.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> encontrarTodos() {
        return this.vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo encontrarPorId(int id) {
        return this.vehiculoRepository.encontrarPorId(id);
    }

    @Override
    public void crearUsuario(Vehiculo vehiculo) {
        this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void actualizarUsuario(Vehiculo vehiculo) {
        this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminarUsuario(int id) {

    }
}
