package com.projetodrogas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetodrogas.entities.Medicamento;
import com.projetodrogas.services.MedicamentoService;



@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	private final MedicamentoService medicamentoService;

	@Autowired
	public MedicamentoController(MedicamentoService medicamentoService) {
		this.medicamentoService = medicamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> buscaMedicamentoControlId(@PathVariable Long id) {
		Medicamento medicamento = medicamentoService.getMedicamentoById(id);
		if (medicamento != null) {
			return ResponseEntity.ok(medicamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Medicamento>> buscaTodasMedicamentosControl() {
		List<Medicamento> medicamento = medicamentoService.getAllMedicamentos();
		return ResponseEntity.ok(medicamento);
	}

	@PostMapping("/")
	public ResponseEntity<Medicamento> saveMedicamentoControl(@RequestBody Medicamento medicamento) {
		Medicamento saveMedicamento = medicamentoService.saveMedicamento(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveMedicamento);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Medicamento> alteraMedicamentoControl(@PathVariable Long id, @RequestBody Medicamento medicamento) {
		Medicamento alteraMedicamento = medicamentoService.changeMedicamento(id, medicamento);

		if (alteraMedicamento != null) {
			return ResponseEntity.ok(medicamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMedicamentoControl(@PathVariable Long id) {
		boolean delete = medicamentoService.deleteMedicamento(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}