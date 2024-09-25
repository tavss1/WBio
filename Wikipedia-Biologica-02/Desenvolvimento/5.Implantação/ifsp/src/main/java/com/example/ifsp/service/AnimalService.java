package com.example.ifsp.service;

import com.example.ifsp.dto.AnimalDTO;
import com.example.ifsp.model.Animal;
import com.example.ifsp.model.DadosAnimal;
import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<AnimalDTO> converteDados(List<Animal> animais) {
        return  animais.stream().map(a -> new AnimalDTO(a.getId(), a.getNomePopular(), a.getHabitat(), a.getAlimentacao(), a.getPeso(), a.getEspecie(), a.getGenero(), a.getFamilia(), a.getOrdem(), a.getClasse(), a.getFilo(), a.getDescricao(), a.getImagem()))
                .collect(Collectors.toList());
    }

    public AnimalDTO converteDado(Animal a) {
        return new AnimalDTO(a.getId(), a.getNomePopular(), a.getHabitat(), a.getAlimentacao(), a.getPeso(), a.getEspecie(), a.getGenero(), a.getFamilia(), a.getOrdem(), a.getClasse(), a.getFilo(), a.getDescricao(), a.getImagem());
    }

    public List<AnimalDTO> listarTodosOsAnimais() {
        return converteDados(animalRepository.findAll());
    }

    public List<AnimalDTO> filtroFilo(String filo) {
        return converteDados(animalRepository.findByFiloContainingIgnoreCase(filo));
    }

    public List<AnimalDTO> filtroClasse(String classe) {
        return converteDados(animalRepository.findByClasseContainingIgnoreCase(classe));
    }

    public List<AnimalDTO> filtroOrdem(String ordem) {
        return converteDados(animalRepository.findByOrdemContainingIgnoreCase(ordem));
    }

    public List<AnimalDTO> filtroFamilia(String familia) {
        return converteDados(animalRepository.findByFamiliaContainingIgnoreCase(familia));
    }

    public List<AnimalDTO> filtroGenero(String genero) {
        return converteDados(animalRepository.findByGeneroContainingIgnoreCase(genero));
    }

    public List<AnimalDTO> pesquisarAnimal(String nome) {
        return converteDados(animalRepository.findByNomePopularContainingIgnoreCase(nome));
    }

    public void adicionarAnimal(DadosAnimal2 dadosAnimal2) {
        var animal = new Animal(dadosAnimal2);
        animalRepository.save(animal);
    }

    public void removerAnimal(Long id){
        animalRepository.deleteById(id);
    }

    public void atualizarAnimal(Long id, Animal animal) {
        animalRepository.findById(id).map(a -> {
            a.setNomePopular(animal.getNomePopular());
            a.setHabitat(animal.getHabitat());
            a.setAlimentacao(animal.getAlimentacao());
            a.setPeso(animal.getPeso());
            a.setEspecie(animal.getEspecie());
            a.setGenero(animal.getGenero());
            a.setFamilia(animal.getFamilia());
            a.setOrdem(animal.getOrdem());
            a.setClasse(animal.getClasse());
            a.setFilo(animal.getFilo());
            return null;
        }).orElse(ResponseEntity.notFound().build());
    }

    public AnimalDTO getDadosAnimal(Long id) {
        return converteDado(animalRepository.findByid(id));
    }
}
