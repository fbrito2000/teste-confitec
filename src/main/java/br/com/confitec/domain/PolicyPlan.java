package br.com.confitec.domain;

import java.util.List;

import lombok.Data;

@Data
public class PolicyPlan {
    List<Coverage> coverages;
    List<StallmentRange> paymentOptions;
}
