/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.access;

import com.unicauca.edu.co.openmarket.commons.domain.Category;
import java.util.List;

/**
 *
 * @author Personal
 */
public interface ICategoryAccess {
     
    boolean saveC(Category newCategory) throws Exception;
    
    boolean editC(Long categoryId, Category category) throws Exception;
    
    boolean deleteC(Long id) throws Exception;

    Category findByIdC(Long id) throws Exception;
    
    Category findByNameC (String name) throws Exception;
    
    List<Category> findAllC() throws Exception;
}
