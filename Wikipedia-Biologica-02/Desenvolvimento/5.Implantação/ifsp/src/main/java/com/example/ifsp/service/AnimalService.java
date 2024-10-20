package com.example.ifsp.service;

import com.example.ifsp.dto.AnimalDTO;
import com.example.ifsp.model.Animal;
import com.example.ifsp.model.DadosAnimal;
import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.repository.AnimalRepository;
import com.example.ifsp.repository.AnimalSpecification;
import com.example.ifsp.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private GeneroService generoService;

    public List<AnimalDTO> converteDados(List<Animal> animais) {
        return  animais.stream().map(a -> new AnimalDTO(a.getId(), a.getNomePopular(), a.getHabitat(), a.getAlimentacao(), a.getPeso(), a.getEspecie(), a.getGenero().getNomeGenero(), a.getGenero().getFamilia().getNomeFamilia(), a.getGenero().getFamilia().getOrdem().getNomeOrdem(), a.getGenero().getFamilia().getOrdem().getClasse().getNomeClasse(), a.getGenero().getFamilia().getOrdem().getClasse().getFilo().getNomeFilo(), a.getDescricao(), a.getImagem()))
                .collect(Collectors.toList());
    }

    public AnimalDTO converteDado(Animal a) {
        return new AnimalDTO(a.getId(), a.getNomePopular(), a.getHabitat(), a.getAlimentacao(), a.getPeso(), a.getEspecie(), a.getGenero().getNomeGenero(), a.getGenero().getFamilia().getNomeFamilia(), a.getGenero().getFamilia().getOrdem().getNomeOrdem(), a.getGenero().getFamilia().getOrdem().getClasse().getNomeClasse(), a.getGenero().getFamilia().getOrdem().getClasse().getFilo().getNomeFilo(), a.getDescricao(), a.getImagem());
    }

    public List<AnimalDTO> listarTodosOsAnimais() {
        return converteDados(animalRepository.findAll());
    }

    public List<AnimalDTO> filtroFilo(String filo) {
        Specification<Animal> spec = Specification.
                where(AnimalSpecification.hasFilo(filo));

        return converteDados(animalRepository.findAll(spec));
    }

    public List<AnimalDTO> filtroClasse(String classe) {
        Specification<Animal> spec = Specification
                .where(AnimalSpecification.hasClasse(classe));
        return converteDados(animalRepository.findAll(spec));
    }

    public List<AnimalDTO> filtroOrdem(String ordem) {
        Specification<Animal> spec = Specification
                .where(AnimalSpecification.hasOrdem(ordem));
        return converteDados(animalRepository.findAll(spec));
    }

    public List<AnimalDTO> filtroFamilia(String familia) {
        Specification<Animal> spec = Specification
                .where(AnimalSpecification.hasFamilia(familia));
        return converteDados(animalRepository.findAll(spec));
    }

    public List<AnimalDTO> filtroGenero(String genero) {
        Specification<Animal> spec = Specification
                .where(AnimalSpecification.hasGenero(genero));
        return converteDados(animalRepository.findAll(spec));
    }

    public List<AnimalDTO> pesquisarAnimal(String nome) {
        return converteDados(animalRepository.findByNomePopularContainingIgnoreCase(nome));
    }

    public void adicionarAnimal(DadosAnimal2 dadosAnimal2) {
        var animal = new Animal(dadosAnimal2, generoService.retornarGenero(dadosAnimal2));
        animalRepository.save(animal);
    }

    public void removerAnimal(Long id){
        animalRepository.deleteById(id);
    }

    public void atualizarAnimal(Long id, DadosAnimal2 animal) {
        animalRepository.findById(id).map(a -> {
            a.setNomePopular(animal.nomePopular());
            a.setHabitat(animal.habitat());
            a.setAlimentacao(animal.alimentacao());
            a.setPeso(animal.peso());
            a.setEspecie(animal.especie());
            a.setDescricao(animal.descricao());
            a.setGenero(generoService.retornarGenero(animal));
            animalRepository.save(a);
            return null;
        }).orElse(ResponseEntity.notFound().build());
    }

    public AnimalDTO getDadosAnimal(Long id) {
        return converteDado(animalRepository.findByid(id));
    }
}
