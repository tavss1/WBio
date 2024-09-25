package com.example.ifsp.repository;

import com.example.ifsp.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByNomePopularContainingIgnoreCase(String nomeAnimal);

    List<Animal> findByEspecieContainingIgnoreCase(String especieAnimal);

    List<Animal> findByGeneroContainingIgnoreCase(String generoAnimal);

    List<Animal> findByFamiliaContainingIgnoreCase(String familiaAnimal);

    List<Animal> findByOrdemContainingIgnoreCase(String ordenAnimal);

    List<Animal> findByClasseContainingIgnoreCase(String classeAnimal);

    List<Animal> findByFiloContainingIgnoreCase(String filoAnimal);

    Animal findByid(long id);
}
