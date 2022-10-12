package com.company.financialmanager.service;

import com.company.financialmanager.entity.Account;
import com.company.financialmanager.entity.Transaction;
import com.company.financialmanager.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.model.CollectionLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountBrowseService {

    @Autowired
    private CurrentAuthentication currentAuthentication;

    public void showCurrentUserProperty(CollectionLoader<Account> collectionLoader) {
        User user = (User) currentAuthentication.getUser();
        if (user.getUsername().equals("admin")) {
            collectionLoader.setQuery("select ac from Account ac");
            collectionLoader.load();
        } else {
            collectionLoader.setParameter("id", user.getId());
            collectionLoader.load();
        }
    }
}