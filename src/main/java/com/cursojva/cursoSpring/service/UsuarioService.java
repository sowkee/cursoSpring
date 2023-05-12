package com.cursojva.cursoSpring.service;

import com.cursojva.cursoSpring.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> encontrarTodos();

    public Usuario encontrarPorId(int id);

    public void crearUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(int id);
}
