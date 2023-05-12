package com.cursojva.cursoSpring.repository;


import com.cursojva.cursoSpring.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    @Query(value = "SELECT v FROM Vehiculo v WHERE v.id=id")
    public Vehiculo encontrarPorId(int id);
}
