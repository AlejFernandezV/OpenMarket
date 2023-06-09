/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.openmarket.server.access.category;

import com.unicauca.edu.co.openmarket.commons.domain.Category;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface ICategoryRepository {
    boolean saveC(Category newCategory);
    
    boolean editC(Long categoryId, Category category);
    
    boolean deleteC(Long id);

    Category findByIdC(Long id);
    
    Category findByNameC (String name);
    
    List<Category> findAllC();
}
