package com.example.ifsp.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

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

    private String especie;

    private String genero;

    private String familia;

    private String ordem;

    private String classe;

    private String filo;

    private String descricao;

    private String imagem;

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
        this.genero = dadosAnimal.taxonomia().genero();
        this.familia = dadosAnimal.taxonomia().familia();
        this.ordem = dadosAnimal.taxonomia().ordem();
        this.filo = dadosAnimal.taxonomia().filo();
        this.classe = dadosAnimal.taxonomia().classe();
    }

    public Animal() {}

    public Animal(DadosAnimal2 dadosAnimal2){
        this.nomePopular = dadosAnimal2.nomePopular();
        this.habitat = dadosAnimal2.habitat();
        this.alimentacao = dadosAnimal2.alimentacao();
        this.peso = dadosAnimal2.peso();
        this.especie = dadosAnimal2.especie();
        this.genero = dadosAnimal2.genero();
        this.familia = dadosAnimal2.filo();
        this.ordem = dadosAnimal2.ordem();
        this.classe = dadosAnimal2.classe();
        this.filo = dadosAnimal2.filo();
        this.descricao = dadosAnimal2.descricao();
        this.imagem = dadosAnimal2.imagem();
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
                ", genero='" + genero +
                ", familia='" + familia +
                ", ordem='" + ordem +
                ", classe='" + classe +
                ", filo='" + filo + '}';
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
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
}
