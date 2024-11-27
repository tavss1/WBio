package com.example.ifsp.service;

import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.model.Genero;
import com.example.ifsp.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private FamiliaService familiaService;

    public Genero retornarGenero(DadosAnimal2 dadosAnimal2) {
        if(generoRepository.findFirstByNomeGeneroContainingIgnoreCase(dadosAnimal2.genero()) == null){
            return novoGenero(dadosAnimal2);
        }else{
            return generoRepository.findFirstByNomeGeneroContainingIgnoreCase(dadosAnimal2.genero());
        }
    }

    public Genero novoGenero(DadosAnimal2 dadosAnimal2) {
        Genero genero = new Genero(dadosAnimal2.genero(), familiaService.retornarFamilia(dadosAnimal2));
        generoRepository.save(genero);

        return genero;
    }
}
