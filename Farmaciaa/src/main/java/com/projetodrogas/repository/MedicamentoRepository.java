package com.projetodrogas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodrogas.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}