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
    public Usuario encontrarPorId(int idUsuario) {

        return this.usuarioRepository.encontrarPorId(idUsuario);
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
        System.out.println("####### " + id);
        Usuario usuario = this.usuarioRepository.getById(id);
        System.out.println("@@@@@@ " + usuario.toString());
        if (usuario != null){
            this.usuarioRepository.delete(usuario);
        }
    }



}
