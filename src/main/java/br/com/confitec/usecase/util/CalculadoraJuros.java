package br.com.confitec.usecase.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraJuros {

    public static Map<Integer, BigDecimal> obterValoresPorFaixa(BigDecimal valorApolice, BigDecimal juros, int [] parcelas) {
        
        Map<Integer, BigDecimal> valorTotalFaixa = new HashMap<>();

        for (int i : parcelas) {
            System.out.println("Parcela " + i);
            valorTotalFaixa.put(i, applyFormula(i,valorApolice,juros));
        }
        return valorTotalFaixa;
    }

    private static BigDecimal applyFormula(int quantidadeParcelas, BigDecimal valorApolice, BigDecimal juros) {
        System.out.println("Quantidade de Parcelas: " + quantidadeParcelas);
        System.out.println("Valor Apólice: " + valorApolice);
        System.out.println("Juros " + juros);
        return BigDecimal.ONE.add(juros).pow(quantidadeParcelas).multiply(valorApolice).setScale(2, RoundingMode.HALF_UP);
    }
}
