package com.company.financialmanager.screen.account;

import com.company.financialmanager.entity.Category;
import com.company.financialmanager.service.AccountBrowseService;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Account.browse")
@UiDescriptor("account-browse.xml")
@LookupComponent("accountsTable")
public class AccountBrowse extends StandardLookup<Account> {

    @Autowired
    AccountBrowseService accountBrowseService;

    @Autowired
    private CollectionLoader<Account> accountsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        accountBrowseService.showCurrentUserProperty(accountsDl);
    }

}