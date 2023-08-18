package br.com.confitec.endpoint.entity.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApoliceVM {

    List<CoberturaVM> listCobertura; 
    List<OpcaoParcelamentoVM> listOpcaoParcelamento;
    
}
