/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class CategoryRepositoryImplArrays implements ICategoryRepository{
    /**
     * Array List de clientes
     */
    private static List<Category> categories;

    public CategoryRepositoryImplArrays() {
        if (categories == null){
            categories = new ArrayList();
        }
        
        if (categories.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        categories.add(new Category(1L,"Categoria 1"));
        categories.add(new Category(2L,"Categoria 2"));
        categories.add(new Category(3L,"Categoria 3"));
        categories.add(new Category(4L,"Categoria 4"));
        categories.add(new Category(5L,"Categoria 5"));
        categories.add(new Category(6L,"Categoria 6"));
        categories.add(new Category(7L,"Categoria 7"));
        categories.add(new Category(8L,"Categoria 8"));
    }

    @Override
    /**
    * Agrega una categoria en el arreglo
    *
    * @param newCategory nuevo objeto categoria que se agregará
    * @return true si se agregó con éxito, en caso contrario false.
    */
    public boolean saveC(Category newCategory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Edita una categoria en el arreglo
    * 
    * @param categoryId Id de la categoria a editar
    * @param category objeto categoria ya editado
    * @return true si se editó con éxito, en caso contrario false.
    */
    public boolean editC(Long categoryId, Category category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Elimina una categoria en el arreglo
    *
    * @param id Id de la categoria que se eliminará del arreglo
    * @return true si se elimina con éxito, en caso contrario false.
    */
    public boolean deleteC(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Encuentra una categoria por Id en el arreglo
    *
    * @param id Id de la categria que se encontrará del arreglo
    * @return Objeto categoria encontrado por el Id.
    */
    public Category findByIdC(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Encuentra una categoria por Id en el arreglo
    *
    * @param name Nombre de la categoria que se encontrará del arreglo
    * @return Objeto categoria encontrado por el nombre.
    */
    public Category findByNameC(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Encuentra todas las categorias del arreglo.
    *
    * @return El arreglo de las categorias
    */
    @Override
    public List<Category> findAllC() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 
}

