package com.company.financialmanager.screen.transaction;

import com.company.financialmanager.entity.Account;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Transaction;

import java.math.BigDecimal;
import java.util.Objects;


@UiController("Transaction_.edit")
@UiDescriptor("transaction-edit.xml")
@EditedEntityContainer("transactionDc")
public class TransactionEdit extends StandardEditor<Transaction> {

    private Long sum;
    @Subscribe("sumField")
    public void onSumFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        sum = Objects.requireNonNull(event.getValue()).longValue();
    }

    @Install(to = "fromAccountField", subject = "validator")
    private void fromAccountFieldValidator(Account value) {
        if ( value.getBalance().longValue() < sum ) throw new RuntimeException("Not enough money on your account!!");
    }

    

}