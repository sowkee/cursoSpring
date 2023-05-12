package com.cursojva.cursoSpring.repository;

import com.cursojva.cursoSpring.entities.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcesionarioRepository extends JpaRepository<Concesionario, Integer> {
    @Query(value = "SELECT c FROM Concesionario c WHERE c.id=id")
    public Concesionario encontrarPorId(int id);

}
