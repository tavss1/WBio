package com.example.ifsp.service;

import com.example.ifsp.model.Classe;
import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private FiloService filoService;

    public Classe retornaClasse(DadosAnimal2 dadosAnimal2) {
        if(classeRepository.findFirstByNomeClasseContainingIgnoreCase(dadosAnimal2.classe()) == null){
            return novaClasse(dadosAnimal2);
        }else{
            return classeRepository.findFirstByNomeClasseContainingIgnoreCase(dadosAnimal2.classe());
        }
    }

    private Classe novaClasse(DadosAnimal2 dadosAnimal2) {
        Classe classe = new Classe(dadosAnimal2.classe(), filoService.retornaFilo(dadosAnimal2));
        classeRepository.save(classe);

        return classe;
    }
}
