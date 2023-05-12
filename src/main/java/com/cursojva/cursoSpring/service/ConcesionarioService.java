package com.cursojva.cursoSpring.service;

import com.cursojva.cursoSpring.entities.Concesionario;
import com.cursojva.cursoSpring.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConcesionarioService {
    public List<Concesionario> encontrarTodos();
    public Concesionario encontrarPorId(int id);

    public void crearConcesionario (Concesionario concesionario);

    public void actualizarConcesionario (Concesionario concesionario);

    public void eliminarConcesionario(int id);
}
