package br.com.confitec.usecase.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.confitec.domain.InformacaoValoresParcela;

public class CalculadoraParcela {

    public static List<InformacaoValoresParcela> calcularParcelas(Map<Integer,BigDecimal> valoresTotaisPorQuantidadeDeParcelas) {
        
        List<InformacaoValoresParcela> listInformacaoValoresParcela = new ArrayList<>();

        valoresTotaisPorQuantidadeDeParcelas.forEach((numeroParcelas, valorTotalParcelas) -> {
            System.out.println(numeroParcelas + ":" + valorTotalParcelas);
           
            
            BigDecimal valorDemaisParcelasBruto = valorTotalParcelas.divide(BigDecimal.valueOf(numeroParcelas),3 ,RoundingMode.UP);
            System.out.println("Valor:demais parcelas Bruto R$ " + valorDemaisParcelasBruto);

            BigDecimal valorDemaisParcelasLiquido = valorDemaisParcelasBruto.setScale(2, RoundingMode.DOWN);
            System.out.println("Valor demais parcelas líquido:" + valorDemaisParcelasLiquido);

            BigDecimal miliavosParcela = valorDemaisParcelasBruto.subtract(valorDemaisParcelasLiquido);
            System.out.println("Miliavos de uma parcela: " + miliavosParcela);

            BigDecimal totalMiliavos = miliavosParcela.multiply(BigDecimal.valueOf(numeroParcelas));
            System.out.println("Total de miliavos das parcelas: " + totalMiliavos);

            BigDecimal valorPrimeiraParcela = valorDemaisParcelasLiquido.add(totalMiliavos);
            System.out.println("Valor Primeira parcela :" + valorPrimeiraParcela);

            listInformacaoValoresParcela.add(new InformacaoValoresParcela(numeroParcelas, valorPrimeiraParcela, valorDemaisParcelasLiquido, valorTotalParcelas));
        });
        
        return listInformacaoValoresParcela;
    }
    
}
