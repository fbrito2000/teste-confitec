package br.com.confitec.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpcaoParcelamento {
    private BigDecimal juros = BigDecimal.ZERO;
    
}
/**
REQUEST
{
    "listCobertura": [
        {
            "cobertura": 1,
            "valor": 123.12
        },
        {
            "cobertura": 4,
            "valor": 345.45
        }
    ],
    "listOpcaoParcelamento": [
        {
            "quantidadeMinimaParcelas": 1,
            "quantidadeMaximaParcelas": 6,
            "juros": 0
        },
        {
            "quantidadeMinimaParcelas": 7,
            "quantidadeMaximaParcelas": 9,
            "juros": 0.01
        },
        {
            "quantidadeMinimaParcelas": 10,
            "quantidadeMaximaParcelas": 12,
            "juros": 0.03
        }
    ]
}
RESPONSE
{
    "dados": [
        {
            "quantidadeParcelas": 1,
            "valorPrimeiraParcela": 468.57,
            "valorParcelamentoTotal": 468.57
        },
        {
            "quantidadeParcelas": 2,
            "valorPrimeiraParcela": 234.29,
            "valorDemaisParcelas": 234.28,
            "valorParcelamentoTotal": 468.57
        },
        {
            "quantidadeParcelas": 3,
            "valorPrimeiraParcela": 156.19,
            "valorDemaisParcelas": 156.19,
            "valorParcelamentoTotal": 468.57
        },
        {
            "quantidadeParcelas": 4,
            "valorPrimeiraParcela": 117.15,
            "valorDemaisParcelas": 117.14,
            "valorParcelamentoTotal": 468.57
        },
        {
            "quantidadeParcelas": 5,
            "valorPrimeiraParcela": 93.73,
            "valorDemaisParcelas": 93.71,
            "valorParcelamentoTotal": 468.57
        },
        {
            "quantidadeParcelas": 6,
            "valorPrimeiraParcela": 78.12,
            "valorDemaisParcelas": 78.09,
            "valorParcelamentoTotal": 468.57
        },
        {
            "quantidadeParcelas": 7,
            "valorPrimeiraParcela": 71.81,
            "valorDemaisParcelas": 71.76,
            "valorParcelamentoTotal": 502.37
        },
        {
            "quantidadeParcelas": 8,
            "valorPrimeiraParcela": 63.45,
            "valorDemaisParcelas": 63.42,
            "valorParcelamentoTotal": 507.39
        },
        {
            "quantidadeParcelas": 9,
            "valorPrimeiraParcela": 56.95,
            "valorDemaisParcelas": 56.94,
            "valorParcelamentoTotal": 512.47
        },
        {
            "quantidadeParcelas": 10,
            "valorPrimeiraParcela": 62.99,
            "valorDemaisParcelas": 62.97,
            "valorParcelamentoTotal": 629.72
        },
        {
            "quantidadeParcelas": 11,
            "valorPrimeiraParcela": 59.01,
            "valorDemaisParcelas": 58.96,
            "valorParcelamentoTotal": 648.61
        },
        {
            "quantidadeParcelas": 12,
            "valorPrimeiraParcela": 55.70,
            "valorDemaisParcelas": 55.67,
            "valorParcelamentoTotal": 668.07
        }
    ]
} **/