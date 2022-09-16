package com.company.financialmanager.service;

import com.company.financialmanager.entity.Account;
import com.company.financialmanager.entity.Transaction;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntityChangedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class TransactionBrowseService {
    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onTransactionChangedBeforeCommit(EntityChangedEvent<Transaction> event) {
        Transaction transaction = dataManager.load(Transaction.class).id(event.getEntityId()).one();
        Account account = transaction.getFromAccount();
        account.setBalance(account.getBalance().subtract(transaction.getSum()));
        dataManager.save(account);
    }

}