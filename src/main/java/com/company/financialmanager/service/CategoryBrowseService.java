package com.company.financialmanager.service;

import com.company.financialmanager.entity.Category;
import com.company.financialmanager.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.model.CollectionLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryBrowseService {

    @Autowired
    private CurrentAuthentication currentAuthentication;

    public void showCurrentUserProperty(CollectionLoader<Category> collectionLoader) {
        User user = (User) currentAuthentication.getUser();
        if (user.getUsername().equals("admin")) {
            collectionLoader.setQuery("select cat from Category cat");
            collectionLoader.load();

        } else {
            collectionLoader.setParameter("id", user.getId());
            collectionLoader.load();
        }
    }
}