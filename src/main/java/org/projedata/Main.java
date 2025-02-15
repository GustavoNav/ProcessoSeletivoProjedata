package org.projedata;

import org.projedata.core.Principal;
import org.projedata.utils.Loader;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Principal principal = new Principal();

        Loader.loadData(principal); // 3.1 Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        principal.popFuncionario("João"); // 3.2 Remover o funcionário “João” da lista.
        principal.printFuncionarios(); // 3.3 Imprimir todos os funcionários com todas suas informações
        principal.updateSalario(0.1); // 3.4 – Os funcionários receberam 10% de aumento de salário.
        principal.printFuncionarioByFuncao(); // 3.5 e 3.6 – Agrupar os funcionários por função em um MAP e  Imprimir
        principal.printAniversarioNosMeses(10, 12); // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        principal.printFuncionarioMaiorIdade(); // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        principal.printNomesEmOrdem(); // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        principal.printTotalSalarios(); // 3.11 – Imprimir o total dos salários dos funcionários.
        principal.printSalarioMinimos(new BigDecimal("1212.00")); // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
    }
}