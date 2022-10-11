package com.company.financialmanager.service;

import com.company.financialmanager.entity.Account;
import com.company.financialmanager.entity.Transaction;
import com.company.financialmanager.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.model.CollectionLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class TransactionBrowseService {
    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentAuthentication currentAuthentication;
    @EventListener
    public void onTransactionChangedBeforeCommit(EntityChangedEvent<Transaction> event) {
        Transaction transaction = dataManager.load(Transaction.class).id(event.getEntityId()).one();
        Account account = transaction.getFromAccount();
        account.setBalance(account.getBalance().subtract(transaction.getSum()));
        dataManager.save(account);
    }

    public void showCurrentUserProperty(CollectionLoader<Transaction> collectionLoader) {
        User user = (User) currentAuthentication.getUser();
        if (user.getUsername().equals("admin")) {
            collectionLoader.setQuery("select tr from Transaction_ tr");
            collectionLoader.load();
        } else {
            collectionLoader.setParameter("id", user.getId());
            collectionLoader.load();
        }
    }

}