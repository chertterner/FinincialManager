package com.company.financialmanager.screen.transaction;

import com.company.financialmanager.entity.User;
import com.company.financialmanager.service.TransactionBrowseService;
import com.company.financialmanager.service.UserService;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Transaction_.browse")
@UiDescriptor("transaction-browse.xml")
@LookupComponent("transactionsTable")
public class TransactionBrowse extends StandardLookup<Transaction> {

    @Autowired
    private CollectionLoader<Transaction> transactionsDl;

    @Autowired
    private TransactionBrowseService transactionBrowseService;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        transactionBrowseService.showCurrentUserProperty(transactionsDl);
    }


}