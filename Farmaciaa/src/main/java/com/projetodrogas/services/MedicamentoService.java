package com.projetodrogas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodrogas.entities.Medicamento;
import com.projetodrogas.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
	private final MedicamentoRepository medicamentoRepository;

	@Autowired
	public MedicamentoService(MedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}

	public List<Medicamento> getAllMedicamentos() {
		return medicamentoRepository.findAll();
	}

	public Medicamento getMedicamentoById(Long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		return medicamento.orElse(null);
	}

	public Medicamento saveMedicamento(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}

	public Medicamento changeMedicamento(Long id, Medicamento changeMedicamento) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			changeMedicamento.setId(id);
			return medicamentoRepository.save(changeMedicamento);
		}
		return null;
	}

	public boolean deleteMedicamento(Long id) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			medicamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
