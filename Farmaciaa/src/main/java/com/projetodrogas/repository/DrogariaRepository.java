package com.projetodrogas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetodrogas.entities.Drogaria;

public interface DrogariaRepository extends JpaRepository<Drogaria, Long> {

}