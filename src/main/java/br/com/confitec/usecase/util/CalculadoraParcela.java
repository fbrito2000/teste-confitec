package br.com.confitec.usecase.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.confitec.domain.InformacaoValoresParcela;

public class CalculadoraParcela {

	public static void main(String[] args) {
		System.out.println(calcularParcelas(BigDecimal.valueOf(101.33), 4));
	}
    public static InformacaoValoresParcela calcularParcelas(BigDecimal valorTotalComJuros, int parcelas) {
        
        System.out.println("Parcelas: " + parcelas);
        
        valorTotalComJuros = valorTotalComJuros.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal valorDemaisParcelasBruto = valorTotalComJuros.divide(BigDecimal.valueOf(parcelas).setScale(2, RoundingMode.HALF_EVEN));
        System.out.println("Valor:demais parcelas Bruto R$ " +valorDemaisParcelasBruto);

        BigDecimal valorDemaisParcelasLiquido = valorDemaisParcelasBruto.setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("Valor demais parcelas líquido:" + valorDemaisParcelasLiquido);

        BigDecimal miliavosParcela = valorDemaisParcelasBruto.subtract(valorDemaisParcelasLiquido);
        System.out.println("Miliavos de uma parcela: " + miliavosParcela);

        BigDecimal totalMiliavos = miliavosParcela.multiply(BigDecimal.valueOf(parcelas));
        System.out.println("Total de miliavos das parcelas: " + totalMiliavos);

        BigDecimal valorPrimeiraParcela = valorDemaisParcelasLiquido.add(totalMiliavos);
        System.out.println("Valor Primeira parcela :" + valorPrimeiraParcela);

        return new InformacaoValoresParcela(parcelas, valorPrimeiraParcela, valorDemaisParcelasLiquido, valorTotalComJuros);
    }
    
}
