package com.company.financialmanager.screen.category;

import com.company.financialmanager.service.CategoryBrowseService;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Category;
import io.jmix.ui.xml.layout.loader.ContainerLoader;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Category.browse")
@UiDescriptor("category-browse.xml")
@LookupComponent("categoriesTable")
public class CategoryBrowse extends StandardLookup<Category> {

    @Autowired
    CategoryBrowseService categoryBrowseService;

    @Autowired
    CollectionLoader<Category> categoriesDl;
    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        categoryBrowseService.showCurrentUserProperty(categoriesDl);
    }


}