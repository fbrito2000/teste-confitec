package br.com.confitec.usecase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import br.com.confitec.domain.Apolice;
import br.com.confitec.domain.Cobertura;
import br.com.confitec.domain.InformacaoValoresParcela;
import br.com.confitec.usecase.util.CalculadoraJuros;
import br.com.confitec.usecase.util.CalculadoraParcela;

@Service
public class GerarOpcoesDePagamento {
  
    private int [] FAIXA_1 = {1,2,3,4,5,6};
    private int [] FAIXA_2 = {7,8,9};
    private int [] FAIXA_3 = {10,11,12};

    public List<InformacaoValoresParcela> execute(Apolice apolice) {
        BigDecimal VALOR_TOTAL_COBERTURAS = BigDecimal.ZERO;

        List<InformacaoValoresParcela> informacaoValoresParcela = new ArrayList<>(12); 

        //Passo 1: obter valor total das coberturas
        List<Cobertura> listCoberturas = apolice.getListCobertura();
            
        for (Cobertura cobertura : listCoberturas) {
            System.out.println("Valor Cobertura: " + cobertura.getValor());
            VALOR_TOTAL_COBERTURAS = VALOR_TOTAL_COBERTURAS.add(cobertura.getValor());
        }
    
        System.out.println("VALOR_TOTAL_COBERTURAS " + VALOR_TOTAL_COBERTURAS);
        //Passo 2: obter os juros das faixas de parcelamento
        final BigDecimal JUROS_FAIXA_1 = apolice.getListOpcaoParcelamento().get(0).getJuros();
        final BigDecimal JUROS_FAIXA_2 = apolice.getListOpcaoParcelamento().get(1).getJuros();
        final BigDecimal JUROS_FAIXA_3 = apolice.getListOpcaoParcelamento().get(2).getJuros();

        System.out.println("JUROS_FAIXA_1 " + JUROS_FAIXA_1);
        System.out.println("JUROS_FAIXA_2 " + JUROS_FAIXA_2);
        System.out.println("JUROS_FAIXA_3 " + JUROS_FAIXA_3);

        //Obter valor total com juros levando em consideração as faixas
        Map<Integer, BigDecimal> parcelasFaixa1 =
        CalculadoraJuros.obterValoresPorFaixa(VALOR_TOTAL_COBERTURAS, JUROS_FAIXA_1, FAIXA_1);
        Map<Integer, BigDecimal> parcelasFaixa2 =
        CalculadoraJuros.obterValoresPorFaixa(VALOR_TOTAL_COBERTURAS, JUROS_FAIXA_2, FAIXA_2);
        Map<Integer, BigDecimal> parcelasFaixa3 =
        CalculadoraJuros.obterValoresPorFaixa(VALOR_TOTAL_COBERTURAS, JUROS_FAIXA_3, FAIXA_3);

        parcelasFaixa1.forEach((k, v) -> System.out.println((k + ":" + v)));
        parcelasFaixa2.forEach((k, v) -> System.out.println((k + ":" + v)));
        parcelasFaixa3.forEach((k, v) -> System.out.println((k + ":" + v)));

        Map<Integer, BigDecimal> parcelasComTodasAsFaixas = new HashMap<>();
        parcelasComTodasAsFaixas.putAll(parcelasFaixa1);
        parcelasComTodasAsFaixas.putAll(parcelasFaixa2);
        parcelasComTodasAsFaixas.putAll(parcelasFaixa3);
        System.out.println("Parcelas com todas as faixas: INICIO\n");
        parcelasComTodasAsFaixas.forEach((k, v) -> System.out.println((k + ":" + v)));
        System.out.println("Parcelas com todas as faixas: FIM\n");
        return CalculadoraParcela.calcularParcelas(parcelasComTodasAsFaixas);
        
    }
}
