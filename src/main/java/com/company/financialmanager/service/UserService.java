package com.company.financialmanager.service;

import com.company.financialmanager.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.model.CollectionLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    public void showCurrentUserProperty(CollectionLoader<?> collectionLoader) {
        User user = (User) currentAuthentication.getUser();
        collectionLoader.setParameter("id", user.getId());
        collectionLoader.load();
    }
}