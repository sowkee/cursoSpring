package com.cursojva.cursoSpring.implementacion;


import com.cursojva.cursoSpring.entities.Usuario;
import com.cursojva.cursoSpring.repository.UsuarioRepository;
import com.cursojva.cursoSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioService {

    //Injeccion de dependencia
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> encontrarTodos() {

        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario encontrarPorId(int id) {

        return this.usuarioRepository.encontrarPorId(id);
    }

    @Override
    public void crearUsuario(Usuario usuario) {

        this.usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {

        this.usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        
    }



}