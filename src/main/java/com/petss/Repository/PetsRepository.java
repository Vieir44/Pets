package com.petss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petss.Entity.Pets;

public interface PetsRepository extends JpaRepository<Pets, Long> {

}
