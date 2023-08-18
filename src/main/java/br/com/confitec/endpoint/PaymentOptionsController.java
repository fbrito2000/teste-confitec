package br.com.confitec.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confitec.adapter.ApoliceAdapter;
import br.com.confitec.endpoint.entity.request.ApoliceVM;
import br.com.confitec.usecase.CalcularPrecos;

@RestController
@RequestMapping("/confitec/teste/parcelamento")
public class PaymentOptionsController {
    
    @Autowired
    CalcularPrecos calcularPrecos;

    @PostMapping()
    public void create(@RequestBody ApoliceVM apoliceVM) {

        ApoliceAdapter adapter = new ApoliceAdapter();
        calcularPrecos.montarProposta(adapter.toApolice(apoliceVM));
    }
}
