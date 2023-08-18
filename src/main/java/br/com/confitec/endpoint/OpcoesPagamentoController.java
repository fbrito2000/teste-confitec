package br.com.confitec.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confitec.adapter.ApoliceAdapter;
import br.com.confitec.adapter.ResponseAdapter;
import br.com.confitec.endpoint.entity.request.ApoliceVM;
import br.com.confitec.endpoint.entity.response.OpcoesPagamentoResponse;
import br.com.confitec.usecase.GerarOpcoesDePagamento;

@RestController
@RequestMapping("/confitec/teste/parcelamento")
public class OpcoesPagamentoController {
    
    @Autowired
    GerarOpcoesDePagamento gerarOpcoesDePagamento;

    @PostMapping()
    public OpcoesPagamentoResponse execute(@RequestBody ApoliceVM apoliceVM) {
 
        OpcoesPagamentoResponse response = new OpcoesPagamentoResponse();
        response.setDados(ResponseAdapter.toInformacaoValoresParcelaVM(gerarOpcoesDePagamento.execute(ApoliceAdapter.toApolice(apoliceVM))));
        return response;
    }
}
