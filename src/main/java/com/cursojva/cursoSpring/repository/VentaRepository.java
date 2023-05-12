package com.cursojva.cursoSpring.repository;

import com.cursojva.cursoSpring.entities.Usuario;
import com.cursojva.cursoSpring.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    @Query(value = "SELECT a FROM Venta a WHERE a.id=id")
    public Venta encontrarPorId(int id);
}
