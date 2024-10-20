package com.example.ifsp.service;

import com.example.ifsp.model.DadosAnimal2;
import com.example.ifsp.model.Filo;
import com.example.ifsp.repository.FiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiloService {

    @Autowired
    private FiloRepository filoRepository;

    public Filo retornaFilo(DadosAnimal2 dadosAnimal2) {

        if(filoRepository.findFirstByNomeFiloContainingIgnoreCase(dadosAnimal2.filo()) == null){
            return novoFilo(dadosAnimal2);
        }else {
            return filoRepository.findFirstByNomeFiloContainingIgnoreCase(dadosAnimal2.filo());
        }
    }

    private Filo novoFilo(DadosAnimal2 dadosAnimal2) {
        Filo filo = new Filo(dadosAnimal2.filo());
        filoRepository.save(filo);

        return filo;
    }
}
