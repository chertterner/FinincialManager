package com.company.financialmanager.screen.category;

import io.jmix.ui.screen.*;
import com.company.financialmanager.entity.Category;

@UiController("Category.edit")
@UiDescriptor("category-edit.xml")
@EditedEntityContainer("categoryDc")
public class CategoryEdit extends StandardEditor<Category> {
}