package br.com.confitec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confitec.domain.PolicyPlan;
import br.com.confitec.usecase.CreatePolicyPlan;

@RestController
@RequestMapping("/confitec/teste/parcelamento")
public class PaymentOptionsController {
    
    @Autowired
    CreatePolicyPlan createPolicyPlan;

    @PostMapping()
    public void create(@RequestBody PolicyPlan policyPlan) {
        createPolicyPlan.execute();
    }
}
