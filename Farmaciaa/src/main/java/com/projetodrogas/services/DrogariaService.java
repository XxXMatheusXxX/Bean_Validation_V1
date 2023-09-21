package com.projetodrogas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodrogas.entities.Drogaria;
import com.projetodrogas.repository.DrogariaRepository;


@Service
public class DrogariaService {
	private final DrogariaRepository drogariaRepository;


	@Autowired
	public DrogariaService(DrogariaRepository drogariaRepository) {
		this.drogariaRepository = drogariaRepository;
	}

	public List<Drogaria> getAllDrogarias() {
		return drogariaRepository.findAll();
	}

	public Drogaria getDrogariaById(Long id) {
		Optional<Drogaria> drogaria = drogariaRepository.findById(id);
		return drogaria.orElse(null);
	}

	public Drogaria saveDrogaria(Drogaria drogaria) {
		return drogariaRepository.save(drogaria);
	}

	public Drogaria changeDrogaria(Long id, Drogaria changeDrog) {
		Optional<Drogaria> existeDrogaria = drogariaRepository.findById(id);
		if (existeDrogaria.isPresent()) {
			changeDrog.setId(id);
			return drogariaRepository.save(changeDrog);
		}
		return null;
	}

	public boolean deleteDrogaria(Long id) {
		Optional<Drogaria> existeDrogaria= drogariaRepository.findById(id);
		if (existeDrogaria.isPresent()) {
			drogariaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
