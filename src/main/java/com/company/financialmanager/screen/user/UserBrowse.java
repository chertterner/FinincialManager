package com.company.financialmanager.screen.user;

import com.company.financialmanager.entity.User;
import com.company.financialmanager.service.UserService;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;



@UiController("User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {
    @Autowired
    private CollectionLoader<User> usersDl;

    @Autowired
    private UserService userService;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        userService.showCurrentUserProperty(usersDl);
    }

}