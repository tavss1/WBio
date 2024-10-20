package com.example.ifsp.model;

import com.example.ifsp.repository.GeneroRepository;
import com.example.ifsp.service.GeneroService;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="animais")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String nomePopular;

    private String habitat;

    private String alimentacao;

    private String peso;

    private String descricao;

    private String imagem;

    private String especie;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;



    public Animal(DadosAnimal dadosAnimal) {
        this.nomePopular = dadosAnimal.nome();
        this.habitat = dadosAnimal.caracteristicas().habitat();
        this.alimentacao = dadosAnimal.caracteristicas().alimentacao();
        this.peso = dadosAnimal.caracteristicas().peso();

        String nomeCientifico = dadosAnimal.taxonomia().nomeCientifico();
        if(nomeCientifico == null){
            int firstSpaceIndex = nomeCientifico.indexOf(' ');

            nomeCientifico = nomeCientifico.substring(firstSpaceIndex + 1);
        }

        this.especie = nomeCientifico;


    }

    public Animal() {}

    public Animal(DadosAnimal2 dadosAnimal2, Genero genero){
        this.nomePopular = dadosAnimal2.nomePopular();
        this.habitat = dadosAnimal2.habitat();
        this.alimentacao = dadosAnimal2.alimentacao();
        this.peso = dadosAnimal2.peso();
        this.especie = dadosAnimal2.especie();
        this.descricao = dadosAnimal2.descricao();
        this.imagem = dadosAnimal2.imagem();

        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nomePopular='" + nomePopular +
                ", habitat='" + habitat  +
                ", alimentacao='" + alimentacao +
                ", peso='" + peso +
                ", especie='" + especie +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
