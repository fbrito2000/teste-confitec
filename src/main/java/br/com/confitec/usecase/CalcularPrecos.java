package br.com.confitec.usecase;

import org.springframework.stereotype.Service;

import br.com.confitec.domain.Apolice;
import br.com.confitec.domain.PropostaPagamento;

@Service
public class CalcularPrecos {
    public PropostaPagamento montarProposta(Apolice apolice) {

        return new PropostaPagamento();
        
    }
}
