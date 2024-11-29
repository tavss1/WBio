package com.example.ifsp.repository;

import com.example.ifsp.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long>, JpaSpecificationExecutor<Animal> {

    List<Animal> findByNomePopularContainingIgnoreCase(String nomeAnimal);

    Animal findByid(long id);
}
