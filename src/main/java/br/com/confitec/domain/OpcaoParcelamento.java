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
    private BigDecimal juros;
    //quantidade de parcelas min-max: não declarada para simplificar.
}
