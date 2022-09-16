package com.company.financialmanager.screen.account;

import com.company.financialmanager.service.UserService;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Account.browse")
@UiDescriptor("account-browse.xml")
@LookupComponent("accountsTable")
public class AccountBrowse extends StandardLookup<Account> {
    @Autowired
    private CollectionLoader<Account> accountsDl;

    @Autowired
    private UserService userService;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        userService.showCurrentUserProperty(accountsDl);
    }

}