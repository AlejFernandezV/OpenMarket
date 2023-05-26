/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.Category;
import java.util.ArrayList;
import java.util.List;
import reloj.frameworkobsobs.Observado;

/**
 *
 * @author Alejandro
 */
public class CategoryRepositoryImplArrays extends Observado implements ICategoryRepository{
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
        categories.add(new Category(10000L,"Categoria 1"));
        categories.add(new Category(20000L,"Categoria 2"));
        categories.add(new Category(30000L,"Categoria 3"));
        categories.add(new Category(40000L,"Categoria 4"));
        categories.add(new Category(50000L,"Categoria 5"));
        categories.add(new Category(60000L,"Categoria 6"));
        categories.add(new Category(70000L,"Categoria 7"));
        categories.add(new Category(80000L,"Categoria 8"));
    }

    @Override
    /**
    * Agrega una categoria en el arreglo
    *
    * @param newCategory nuevo objeto categoria que se agregará
    * @return true si se agregó con éxito, en caso contrario false.
    */
    public boolean saveC(Category newCategory) {
        if(!newCategory.equals(null)){
            categories.add(newCategory);
            this.notificar();
            return true;
        }
        return false;
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
        for(int i=0; i < categories.size(); i++){
            if(categories.get(i).getCategoryId().equals(categoryId)){
                categories.set(i, category);
                this.notificar();
                return true;
            }
        }
        return false;
    }

    @Override
    /**
    * Elimina una categoria en el arreglo
    *
    * @param id Id de la categoria que se eliminará del arreglo
    * @return true si se elimina con éxito, en caso contrario false.
    */
    public boolean deleteC(Long id) {
        for(int i=0; i < categories.size(); i++){
            if(categories.get(i).getCategoryId().equals(id)){
                categories.remove(i);
                this.notificar();
                return true;
            }
        }
        return false;
    }

    @Override
    /**
    * Encuentra una categoria por Id en el arreglo
    *
    * @param id Id de la categria que se encontrará del arreglo
    * @return Objeto categoria encontrado por el Id.
    */
    public Category findByIdC(Long id) {
        for(Category c: categories){
            if(c.getCategoryId().equals(id)){
                return c;
            }
        }
        return null;
    }

    @Override
    /**
    * Encuentra una categoria por Id en el arreglo
    *
    * @param name Nombre de la categoria que se encontrará del arreglo
    * @return Objeto categoria encontrado por el nombre.
    */
    public Category findByNameC(String name) {
        for(Category c: categories){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    /**
    * Encuentra todas las categorias del arreglo.
    *
    * @return El arreglo de las categorias
    */
    @Override
    public List<Category> findAllC() {
       return categories;
    } 
}

