package com.cursojva.cursoSpring.implementacion;

import com.cursojva.cursoSpring.entities.Concesionario;
import com.cursojva.cursoSpring.repository.ConcesionarioRepository;
import com.cursojva.cursoSpring.service.ConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioImpl implements ConcesionarioService {

    @Autowired
    ConcesionarioRepository concesionarioRepository;
    @Override
    public List<Concesionario> encontrarTodos() {

        return this.concesionarioRepository.findAll();
    }

    @Override
    public Concesionario encontrarPorId(int id) {
        Concesionario concesionario = this.concesionarioRepository.encontrarPorId(id);
        return concesionario;
    }

    @Override
    public void crearConcesionario(Concesionario concesionario) {

        this.concesionarioRepository.save(concesionario);
    }

    @Override
    public void actualizarConcesionario(Concesionario concesionario) {

        this.concesionarioRepository.save(concesionario);

    }

    @Override
    public void eliminarConcesionario(int id) {
        Concesionario concesionario = this.concesionarioRepository.encontrarPorId(id);
        if(concesionario != null) {
            this.concesionarioRepository.delete(concesionario);
        }
    }
}
