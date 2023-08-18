package br.com.confitec.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Coverage {

    private int coverageId;
    private BigDecimal coverageTotalPrice;
    
}
