package br.com.confitec.endpoint.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CoberturaVM {
    int cobertura;
    double valor;
}
