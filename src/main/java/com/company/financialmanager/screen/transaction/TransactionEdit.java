package com.company.financialmanager.screen.transaction;


import com.company.financialmanager.app.TransactionEditService;
import com.company.financialmanager.entity.Account;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@UiController("Transaction_.edit")
@UiDescriptor("transaction-edit.xml")
@EditedEntityContainer("transactionDc")
public class TransactionEdit extends StandardEditor<Transaction> {

    @Autowired
    TransactionEditService transactionEditService;

    @Subscribe("sumField")
    public void onSumFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        transactionEditService.setSumFromTransactionEditScreen(event);
    }

    @Install(to = "fromAccountField", subject = "validator")
    private void fromAccountFieldValidator(@NotNull Account value) {
        long balance = value.getBalance().longValue();
        long sum = transactionEditService.getSum().longValue();
        if ( balance < sum ) throw new RuntimeException("Not enough money on your account!!");
    }

}