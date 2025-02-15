package org.projedata.core;

import org.projedata.models.Funcionario;
import org.projedata.utils.InnerFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Principal {
    /*
        Classe Principal, para armazenar os funcionarios e executar operações relacionadas.
    */

    private final List<Funcionario> funcionarios = new ArrayList<>();


    public void addFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public void popFuncionario(String nome){
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    public void printFuncionarios(){
        System.out.println("==================================================");
        for (Funcionario f : this.funcionarios){
            System.out.printf("%s %s %s %s \n",
                    f.getNome(),
                    InnerFormatter.formatData(f.getDataNascimento()),
                    InnerFormatter.formatSalario(f.getSalario()),
                    f.getFuncao());
        }
        System.out.println("==================================================");
    }

    public void updateSalario(double valor){
        for (Funcionario f : this.funcionarios){
            BigDecimal salarioAtual = f.getSalario();
            BigDecimal valorConvertido = BigDecimal.valueOf(valor);

            if (valor > 0) {
                f.setSalario(salarioAtual.multiply(valorConvertido.add(new BigDecimal(1))));
            } else if (valor < 0) {
                f.setSalario(salarioAtual.multiply(new BigDecimal(1).subtract(valorConvertido)));
            }
        }
    }

    public Map<String, List<Funcionario>> groupByFuncao(){
        Map<String, List<Funcionario>> funcionarioByFuncao = new HashMap<>();

        for (Funcionario f : this.funcionarios){

            if (funcionarioByFuncao.containsKey(f.getFuncao())){
                funcionarioByFuncao.get(f.getFuncao()).add(f);
            }
            else {
                List<Funcionario> novoAgrupamento = new ArrayList<>();
                novoAgrupamento.add(f);
                funcionarioByFuncao.put(f.getFuncao(), novoAgrupamento);
            }
        }
        return funcionarioByFuncao;
    }

    public void printFuncionarioByFuncao(){
        Map<String, List<Funcionario>> funcionarioByFuncao = groupByFuncao();

        for (Map.Entry<String, List<Funcionario>> e: funcionarioByFuncao.entrySet()){
            String funcao = e.getKey();
            List<Funcionario> funcionarios = e.getValue();

            System.out.printf(">>>%s \n", funcao);
            for (Funcionario f : funcionarios){
                System.out.printf("\t Nome: %s \n", f.getNome());
            }
            System.out.println();
        }
        System.out.println("==================================================");
    }

    public void printAniversarioNosMeses(int A, int B){
        System.out.printf("Funcionarios que fazem aniversário no mes %d ou %d: \n", A, B);
        for (Funcionario f : funcionarios){
            if (f.getDataNascimento().getMonthValue() == A
                    || f.getDataNascimento().getMonthValue() == B){
                System.out.println(f.getNome());
            }
        }
        System.out.println("==================================================");
    }

    public void printFuncionarioMaiorIdade(){
        LocalDate maior = LocalDate.now();
        String nome = "";

        for (Funcionario f : funcionarios){
            if (f.getDataNascimento().isBefore(maior)){
                maior = f.getDataNascimento();
                nome = f.getNome();
            }
        }

        Period periodo = Period.between(maior, LocalDate.now());
        int idade = periodo.getYears();

        System.out.println("Funcionário com a maior idade: ");
        System.out.printf("Nome: %s \nIdade: %s", nome, idade);
        System.out.println("\n==================================================");
    }

    public void printNomesEmOrdem(){
        List<String> nomes = new ArrayList<>();
        for (Funcionario f : funcionarios){
            nomes.add(f.getNome());
        }
        Collections.sort(nomes);
        System.out.println("lista de funcionários por ordem alfabética:");
        for (String n : nomes){
            System.out.println(n);
        }
        System.out.println("==================================================");
    }

    public void printTotalSalarios(){
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : funcionarios){
            total = total.add(f.getSalario());
        }
        System.out.println("total dos salários dos funcionários.: " + InnerFormatter.formatSalario(total));
        System.out.println("==================================================");
    }

    public void printSalarioMinimos(BigDecimal salarioMinimo){
        for ( Funcionario f : funcionarios){
            BigDecimal valor = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " " + valor + "x");
        }
    }
}
