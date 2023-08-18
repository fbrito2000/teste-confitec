package br.com.confitec.adapter;

import java.util.ArrayList;
import java.util.List;

import br.com.confitec.domain.Apolice;
import br.com.confitec.domain.Cobertura;
import br.com.confitec.domain.OpcaoParcelamento;
import br.com.confitec.endpoint.entity.request.ApoliceVM;
import br.com.confitec.endpoint.entity.request.CoberturaVM;
import br.com.confitec.endpoint.entity.request.OpcaoParcelamentoVM;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApoliceAdapter {

    private static Cobertura toCobertura(CoberturaVM coberturaVM) {
        return new Cobertura()
            .builder()
            .cobertura(coberturaVM.getCobertura())
            .valor(coberturaVM.getValor())
            .build();
    }

    private static OpcaoParcelamento toOpcaoParcelamento(OpcaoParcelamentoVM opcaoParcelamentoVM) {
        return new OpcaoParcelamento()
            .builder()
            .quantidadeMinimaParcelas(opcaoParcelamentoVM.getQuantidadeMinimaParcelas())
            .quantidadeMaximaParcelas(opcaoParcelamentoVM.getQuantidadeMaximaParcelas())
            .juros(opcaoParcelamentoVM.getJuros())
            .build();
    }

    private static List<Cobertura> toListCobertura(ApoliceVM apoliceVM) {

        List<Cobertura> listCobertura = new ArrayList<>();
        List<CoberturaVM> listCoberturaVM = apoliceVM.getListCobertura();
        for (CoberturaVM coberturaVM : listCoberturaVM) {
            listCobertura.add(toCobertura(coberturaVM));
        }
        return listCobertura;
    }

    private static List<OpcaoParcelamento> toListOpcaoParcelamento(ApoliceVM apoliceVM) {

        List<OpcaoParcelamento> listOpcaoParcelamento = new ArrayList<>();
        List<OpcaoParcelamentoVM> listOpcaoParcelamentoVM = apoliceVM.getListOpcaoParcelamento();
        for (OpcaoParcelamentoVM opcaoParcelamentoVM : listOpcaoParcelamentoVM) {
            listOpcaoParcelamento.add(toOpcaoParcelamento(opcaoParcelamentoVM));
        }
        return listOpcaoParcelamento;
    }

    public static Apolice toApolice (ApoliceVM apoliceVM) {
        return new Apolice()
            .builder()
            .listCobertura(toListCobertura(apoliceVM))
            .listOpcaoParcelamento(toListOpcaoParcelamento(apoliceVM))
            .build();
    }
}
