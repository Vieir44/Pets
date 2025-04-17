package com.petss.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petss.Entity.Pets;
import com.petss.Service.PetsService;

@RestController
@RequestMapping("pets")

public class PetsController {

	private final PetsService petsService;

	public PetsController(PetsService petsService) {
		this.petsService = petsService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Pets>> getAllPets() {
		List<Pets> pets = petsService.getPetsAll();
		return ResponseEntity.ok(pets);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pets> getPetsById(@PathVariable Long id) {
		Pets pets = petsService.getPetsById(id);
		if (pets != null) {
			return ResponseEntity.ok(pets);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/")
	public ResponseEntity<Pets> criarPets(@RequestBody Pets pets) {
		Pets criarPets = petsService.salvaPet(pets);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPets);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pets> alteraPet(@PathVariable Long id, @RequestBody Pets pets) {
		Pets alteraPet = petsService.alteraPet(id, pets);
		if (alteraPet != null) {
			return ResponseEntity.ok(alteraPet); 
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePets (@PathVariable Long id) {
		boolean deleted = petsService.deletePets(id);
		if (deleted) {
			return ResponseEntity.ok().body("Pet excluído com sucesso");
		}else {
			return ResponseEntity.notFound().build();		}
		
	}

}
