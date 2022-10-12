package com.company.financialmanager.screen.category;

import com.company.financialmanager.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Category.edit")
@UiDescriptor("category-edit.xml")
@EditedEntityContainer("categoryDc")
public class CategoryEdit extends StandardEditor<Category> {

    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Category> event) {
        User user = (User) currentAuthentication.getUser();
        event.getEntity().setUserId(user.getId());
    }


}