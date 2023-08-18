package br.com.confitec.adapter;

import java.util.ArrayList;
import java.util.List;

import br.com.confitec.domain.InformacaoValoresParcela;
import br.com.confitec.endpoint.entity.response.InformacaoValoresParcelaVM;

public class ResponseAdapter {
    
    public static List<InformacaoValoresParcelaVM> toInformacaoValoresParcelaVM (List<InformacaoValoresParcela> listInformacaoValoresParcela) {

        List<InformacaoValoresParcelaVM> informacaoValoresParcelaVMs = new ArrayList<>();
        for (InformacaoValoresParcela informacaoValoresParcela : listInformacaoValoresParcela) {
            informacaoValoresParcelaVMs.add(new InformacaoValoresParcelaVM()
            .builder()
            .quantidadeParcelas(informacaoValoresParcela.getQuantidadeParcelas())
            .valorPrimeiraParcela(informacaoValoresParcela.getValorPrimeiraParcela())
            .valorDemaisParcelas(informacaoValoresParcela.getValorDemaisParcelas())
            .valorParcelamentoTotal(informacaoValoresParcela.getValorParcelamentoTotal())
            .build());
        }
        return informacaoValoresParcelaVMs;
    }
}
