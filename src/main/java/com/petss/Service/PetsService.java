package com.petss.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.petss.Entity.Pets;
import com.petss.Repository.PetsRepository;

@Service
public class PetsService {
	
	private final PetsRepository petsRepository;
	
	public PetsService (PetsRepository petsRepository) {
		this.petsRepository = petsRepository;
	}
	
	public Pets salvaPet(Pets pets) {
		return petsRepository.save(pets);
	}
	
	public Pets getPetsById (Long id) {
		return petsRepository.findById(id).orElse(null);
	}
	
	public List<Pets> getPetsAll() {
		return petsRepository.findAll();
	}
	
	public Pets alteraPet (Long id, Pets alterarPets) {
		Optional<Pets> existePets = petsRepository.findById(id);
		if(existePets.isPresent()) {
			alterarPets.setId(id);
			return petsRepository.save(alterarPets);
		} else {
			return null;
		}
	}
		
		public boolean deletePets(Long id) {
			Optional<Pets> existePets = petsRepository.findById(id);
			if (existePets.isPresent()) {
				petsRepository.deleteById(id);
				return true;
			}else {
				return false;
			}
		
		
	}

	

}
