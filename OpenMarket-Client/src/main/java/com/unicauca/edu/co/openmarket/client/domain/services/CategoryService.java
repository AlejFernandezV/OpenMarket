/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.domain.services;

import com.unicauca.edu.co.openmarket.client.access.ICategoryAccess;
import com.unicauca.edu.co.openmarket.commons.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Personal
 */
public class CategoryService {
    
    private final ICategoryAccess access;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param access implementacion de tipo ICustomerService
     */
    public CategoryService(ICategoryAccess access) {
        this.access = access;
    }

    public boolean saveCategory(String name) throws Exception {
        
        Category newCategory = new Category();
        newCategory.setName(name);
        
        //Validate category
        if (newCategory.getName().isBlank() ) {
            return false;
        }

        return access.saveC(newCategory);

    }

    public List<Category> findAllCategories() throws Exception{
        List<Category> category = new ArrayList<>();
        category = access.findAllC();

        return category;
    }
    
    public Category findCategoryById(Long categoryId) throws Exception{
        return access.findByIdC(categoryId);
    }
    
    public Category findCategoryByName(String categoryName) throws Exception{
        return access.findByNameC(categoryName);
    }
    
    public boolean deleteCategory(Long categoryId) throws Exception{
        return access.deleteC(categoryId);
    }

    public boolean editCategory(Long categoryId, Category category) throws Exception{
        
        //Validate category
        if (category == null || category.getName().isBlank() ) {
            return false;
        }
        return access.editC(categoryId, category);
    }
}
