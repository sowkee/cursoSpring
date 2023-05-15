package com.cursojva.cursoSpring.repository;


import com.cursojva.cursoSpring.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.id=idUsuario")
    public Usuario encontrarPorId(int idUsuario);

}
