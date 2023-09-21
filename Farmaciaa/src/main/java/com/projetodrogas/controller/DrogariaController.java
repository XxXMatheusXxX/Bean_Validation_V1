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

import com.projetodrogas.entities.Drogaria;
import com.projetodrogas.services.DrogariaService;

@RestController
@RequestMapping("/drogaria")
public class DrogariaController {

	private final DrogariaService drogariaService;

	@Autowired
	public DrogariaController(DrogariaService drogariaService) {
		this.drogariaService = drogariaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Drogaria> buscaDrogariaControlId(@PathVariable Long id) {
		Drogaria drogaria = drogariaService.getDrogariaById(id);
		if (drogaria != null) {
			return ResponseEntity.ok(drogaria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Drogaria>> buscaTodasDrogariasControl() {
		List<Drogaria> drogaria = drogariaService.getAllDrogarias();
		return ResponseEntity.ok(drogaria);
	}

	@PostMapping("/")
	public ResponseEntity<Drogaria> saveDrogariaControl(@RequestBody Drogaria drogaria) {
		Drogaria saveDrogaria = drogariaService.saveDrogaria(drogaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveDrogaria);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Drogaria> alteraDrogariaControl(@PathVariable Long id, @RequestBody Drogaria drogaria) {
		Drogaria alteraDrogaria = drogariaService.changeDrogaria(id, drogaria);

		if (alteraDrogaria != null) {
			return ResponseEntity.ok(drogaria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDrogariaControl(@PathVariable Long id) {
		boolean delete = drogariaService.deleteDrogaria(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}