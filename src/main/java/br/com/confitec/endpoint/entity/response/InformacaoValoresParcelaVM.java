package br.com.confitec.endpoint.entity.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformacaoValoresParcelaVM {
    private int quantidadeParcelas;
    private BigDecimal valorPrimeiraParcela;
    private BigDecimal valorDemaisParcelas;
    private BigDecimal valorParcelamentoTotal;
}
