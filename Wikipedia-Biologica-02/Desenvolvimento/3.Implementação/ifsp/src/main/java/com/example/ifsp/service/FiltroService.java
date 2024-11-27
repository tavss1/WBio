package com.example.ifsp.service;

import com.example.ifsp.dto.*;
import com.example.ifsp.model.*;
import com.example.ifsp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filtros")
@CrossOrigin(origins = "http://localhost:5500")
public class FiltroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private OrdemRepository ordemRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private FiloRepository filoRepository;

    @GetMapping("/genero")
    public List<GeneroDTO> obterGeneros() {
        return converteDadosGenero(generoRepository.findAll());
    }

    private List<GeneroDTO> converteDadosGenero(List<Genero> generosList) {
        return generosList.stream().map(g -> new GeneroDTO(g.getId(), g.getNomeGenero()))
                .collect(Collectors.toList());
    }

    @GetMapping("/familia")
    public List<FamiliaDTO> obterFamilia() {
        return converteDadosFamilia(familiaRepository.findAll());
    }

    private List<FamiliaDTO> converteDadosFamilia(List<Familia> familiaList) {
        return familiaList.stream().map(f -> new FamiliaDTO(f.getId(), f.getNomeFamilia()))
                .collect(Collectors.toList());
    }

    // Adicionado para Ordem
    @GetMapping("/ordem")
    public List<OrdemDTO> obterOrdem() {
        return converteDadosOrdem(ordemRepository.findAll());
    }

    private List<OrdemDTO> converteDadosOrdem(List<Ordem> ordemList) {
        return ordemList.stream().map(o -> new OrdemDTO(o.getId(), o.getNomeOrdem()))
                .collect(Collectors.toList());
    }

    // Adicionado para Classe
    @GetMapping("/classe")
    public List<ClasseDTO> obterClasse() {
        return converteDadosClasse(classeRepository.findAll());
    }

    private List<ClasseDTO> converteDadosClasse(List<Classe> classeList) {
        return classeList.stream().map(c -> new ClasseDTO(c.getId(), c.getNomeClasse()))
                .collect(Collectors.toList());
    }

    // Adicionado para Filo
    @GetMapping("/filo")
    public List<FiloDTO> obterFilo() {
        return converteDadosFilo(filoRepository.findAll());
    }

    private List<FiloDTO> converteDadosFilo(List<Filo> filoList) {
        return filoList.stream().map(f -> new FiloDTO(f.getId(), f.getNomeFilo()))
                .collect(Collectors.toList());
    }
}
