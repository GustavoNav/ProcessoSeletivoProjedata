package org.projedata.models;

import java.time.LocalDate;

public class Pessoa {
    protected String nome;
    protected LocalDate data_nascimento;


    public Pessoa(String nome, LocalDate data_nascimento){
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    // GETs e SETs
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public LocalDate getDataNascimento(){
        return data_nascimento;
    }
    public void setDataNascimento(LocalDate data_nascimento){
        this.data_nascimento = data_nascimento;
    }
}
