package br.com.confitec.endpoint.entity.response;

import java.util.List;

import br.com.confitec.domain.InformacaoValoresParcela;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpcoesPagamentoResponse {
    private List<InformacaoValoresParcela> dados;
}
