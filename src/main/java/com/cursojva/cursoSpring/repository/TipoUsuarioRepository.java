package com.cursojva.cursoSpring.repository;

import com.cursojva.cursoSpring.entities.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
