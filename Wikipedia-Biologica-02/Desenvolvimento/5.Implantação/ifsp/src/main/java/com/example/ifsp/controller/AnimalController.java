package com.example.ifsp.controller;

import com.example.ifsp.dto.AnimalDTO;
import com.example.ifsp.model.Animal;
import com.example.ifsp.model.DadosAnimal;
import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping
    public List<AnimalDTO> obterTodosAnimais() {
        return service.listarTodosOsAnimais();
    }

    @GetMapping("/filtro/generos/{genero}")
    public List<AnimalDTO> filtroGenero(@PathVariable String genero) {
        return service.filtroGenero(genero);
    }

    @GetMapping("/filtro/filos/{filo}")
    public List<AnimalDTO> filtroFilo(@PathVariable String filo) {
        return service.filtroFilo(filo);
    }

    @GetMapping("/filtro/classes/{classe}")
    public List<AnimalDTO> filtroClasse(@PathVariable String classe) {
        return service.filtroClasse(classe);
    }

    @GetMapping("/filtro/ordens/{ordem}")
    public List<AnimalDTO> filtroOrdem(@PathVariable String ordem) {
        return service.filtroOrdem(ordem);
    }

    @GetMapping("/filtro/familias/{familia}")
    public List<AnimalDTO> filtroFamilia(@PathVariable String familia) {
        return service.filtroFamilia(familia);
    }

    @GetMapping("/pesquisar/{nome}")
    public List<AnimalDTO> pesquisarAnimal(@PathVariable String nome) {
        return service.pesquisarAnimal(nome);
    }

    @GetMapping("/getDadosAnimal/{id}")
    public AnimalDTO getDadosAnimal(@PathVariable Long id) {
        return service.getDadosAnimal(id);
    }

    @PostMapping("/adicionarAnimal")
    public ResponseEntity<DadosAnimal2> adicionarAnimal(@RequestBody DadosAnimal2 dadosAnimal2) {
        service.adicionarAnimal(dadosAnimal2);
        return ResponseEntity.ok().body(dadosAnimal2);
    }

    @PutMapping("/autalizarAnimal/{id}")
    public ResponseEntity<Animal> alterarAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        service.atualizarAnimal(id, animal);
        return ResponseEntity.ok().body(animal);
    }

    @PutMapping("/removerAnimal/{id}")
    public ResponseEntity<Animal> removerAnimal(@PathVariable Long id){
            service.removerAnimal(id);
            return ResponseEntity.ok().build();
    }


}
