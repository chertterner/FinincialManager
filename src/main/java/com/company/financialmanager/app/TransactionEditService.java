package com.company.financialmanager.app;


import io.jmix.ui.component.HasValue;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionEditService {

    private BigDecimal sum;

    public void setSumFromTransactionEditScreen(HasValue.ValueChangeEvent<BigDecimal> event) {
        sum = event.getValue();
    }

    public BigDecimal getSum() {
        return sum;
    }
}