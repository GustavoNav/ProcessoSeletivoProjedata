package org.projedata.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;


    public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
        super(nome, data_nascimento);
        this.salario =  salario;
        this.funcao = funcao;
    }

    // GETs e SETs
    public BigDecimal getSalario(){
        return salario;
    }
    public void setSalario(BigDecimal salario){
        this.salario = salario;
    }

    public String getFuncao(){
        return funcao;
    }
    public void setFuncao(String funcao){
        this.funcao = funcao;
    }
}
