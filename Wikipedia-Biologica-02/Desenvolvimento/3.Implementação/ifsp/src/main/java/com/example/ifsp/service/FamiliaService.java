package com.example.ifsp.service;

import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.model.Familia;
import com.example.ifsp.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliaService {

    @Autowired
    FamiliaRepository familiaRepository;

    @Autowired
    OrdemService ordemService;


    public Familia retornarFamilia(DadosAnimal2 dadosAnimal2) {

        if(familiaRepository.findFirstByNomeFamiliaContainingIgnoreCase(dadosAnimal2.familia()) == null){
            return novaFamilia(dadosAnimal2);
        }else{
            return familiaRepository.findFirstByNomeFamiliaContainingIgnoreCase(dadosAnimal2.familia());
        }
    }

    private Familia novaFamilia(DadosAnimal2 dadosAnimal2) {
        Familia familia = new Familia(dadosAnimal2.familia(), ordemService.retornarOrdem(dadosAnimal2));
        familiaRepository.save(familia);

        return familia;
    }
}
