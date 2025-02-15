package org.projedata.utils;

import org.projedata.core.Principal;
import org.projedata.models.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loader {
    public static void loadData(Principal principal){
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/funcionarios.txt"));
            String line = reader.readLine();

            while (line != null){
                String[] dados = line.split("-");

                String nome = dados[0].trim();
                LocalDate data_nascimento = LocalDate.parse(dados[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                BigDecimal salario = new BigDecimal(dados[2].trim());
                String funcao = dados[3].trim();

                Funcionario funcionario = new Funcionario(nome, data_nascimento, salario, funcao);
                principal.addFuncionario(funcionario);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
