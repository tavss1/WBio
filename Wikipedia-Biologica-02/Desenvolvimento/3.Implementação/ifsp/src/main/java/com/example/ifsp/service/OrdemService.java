package com.example.ifsp.service;

import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.repository.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ifsp.model.Ordem;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    @Autowired
    private ClasseService classeService;

    public Ordem retornarOrdem(DadosAnimal2 dadosAnimal2) {

        if(ordemRepository.findFirstByNomeOrdemContainingIgnoreCase(dadosAnimal2.ordem()) ==  null){
            return novaOrdem(dadosAnimal2);
        }else{
            return ordemRepository.findFirstByNomeOrdemContainingIgnoreCase(dadosAnimal2.ordem());
        }
    }

    private Ordem novaOrdem(DadosAnimal2 dadosAnimal2) {
        Ordem ordem = new Ordem(dadosAnimal2.ordem(), classeService.retornaClasse(dadosAnimal2));
        ordemRepository.save(ordem);

        return ordem;
    }
}
