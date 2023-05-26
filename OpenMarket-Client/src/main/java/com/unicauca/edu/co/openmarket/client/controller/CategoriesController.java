
package com.unicauca.edu.co.openmarket.client.controller;

import com.unicauca.edu.co.openmarket.client.access.CategoryAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.commands.OMAddCategoryCommand;
import com.unicauca.edu.co.openmarket.client.commands.OMInvoker;
import com.unicauca.edu.co.openmarket.commons.domain.Category;

/**
 *
 * @author Alejandro
 */
public class CategoriesController {
    private CategoryAccessImplSockets categoryAccess;
    private OMInvoker ominvoker;

    public CategoriesController(CategoryAccessImplSockets categoryAccess) {
        this.categoryAccess = categoryAccess;
        this.ominvoker = new OMInvoker();
    }
    
    public CategoryAccessImplSockets getProductService() {
        return categoryAccess;
    }

    public void setProductService(CategoryAccessImplSockets categoryAccess) {
        this.categoryAccess = categoryAccess;
    }

    public OMInvoker getOminvoker() {
        return ominvoker;
    }

    public void setOminvoker(OMInvoker ominvoker) {
        this.ominvoker = ominvoker;
    }

    public boolean addCategory(String name, String description) {
        Category category = new Category(0L,name);
        OMAddCategoryCommand comm = new OMAddCategoryCommand(category, categoryAccess);
        ominvoker.addCommand(comm);
        ominvoker.execute(); 
        
        return comm.result();
    }

    public boolean editProduct(String id, String name) throws Exception {
        if (id.equals("")) {
            return false;
        }
        
        Long categoryId = Long.parseLong(id);
        Category category = new Category();
        category.setName(name);

        return categoryAccess.editC(categoryId, category);
    }
    
    public boolean deleteProduct(String id) throws Exception{
        Long categoryId = Long.parseLong(id);
        return categoryAccess.deleteC(categoryId);
    }
}
