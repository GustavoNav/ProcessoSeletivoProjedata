package org.projedata.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InnerFormatter {
    /*
    Classe responsável por aplicar formatações em dados dos funcionários
    */

    public static String formatData(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public static String formatSalario(BigDecimal salario){
        return String.format("%.2f", salario)
                .replace(',', 'T')
                .replace('.', ',')
                .replace('T', '.');
    }
}
