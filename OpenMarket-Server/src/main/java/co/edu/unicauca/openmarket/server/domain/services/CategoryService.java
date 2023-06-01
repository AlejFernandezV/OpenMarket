/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.domain.services;

import co.edu.unicauca.openmarket.server.access.category.ICategoryRepository;
import co.unicauca.strategyserver.helpers.JsonError;
import co.unicauca.strategyserver.helpers.Utilities;
import com.google.gson.Gson;
import com.unicauca.edu.co.openmarket.commons.domain.Category;
import java.util.ArrayList;
import java.util.List;
import reloj.frameworkobsobs.Observado;

/**
 *
 * @author Alejandro
 */
public class CategoryService extends Observado{

    /**
     * Repositorio de categorias
     */
    ICategoryRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo ICategoryRepository
     */
    public CategoryService(ICategoryRepository repo) {
        this.repo = repo;
    }

    public synchronized Category findByIdCategory(long id) {
        return repo.findByIdC(id);
    }
/**
     * Buscar un Categoria
     *
     * @param name nombre
     * @return objeto tipo Category
     */
    public synchronized Category findByNameCategory(String name) {
        return repo.findByNameC(name);
    }
    /**
     * Crea una nueva categoria. Aplica validaciones de negocio
     *
     * @param category cliente
     * @return devuelve la cadena "true" si fue creado, en caso contrario retornará errorsJson
     */
    public synchronized String createCategory(Category category) {
        List<JsonError> errors = new ArrayList<>();
  
        // Validaciones y reglas de negocio
        if (category.getCategoryId().equals(null) || category.getName().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","Id y nombre son obligatorios. "));
        }
        
        if (category.getCategoryId() < 0){
            errors.add(new JsonError("400", "BAD_REQUEST","El id de categoria no puede ser negativo. "));
        }

        if(!Utilities.isNumeric(category.getCategoryId().toString())){
            errors.add(new JsonError("400", "BAD_REQUEST","El id debe contener sólo dígitos "));
        }
        
        if(Utilities.isNumeric(category.getName())){
            errors.add(new JsonError("400", "BAD_REQUEST","El nombre de la categoria debe contener sólo letras "));
        }
        
        // Que no esté repetido
        Category categorySearched = this.findByIdCategory(category.getCategoryId());
        if (categorySearched != null){
            errors.add(new JsonError("400", "BAD_REQUEST","La categoría ya existe. "));
        }
        
       if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }             
       
       
        return String.valueOf(repo.saveC(category));
    }

    public synchronized String editCategory(Long id, Category category){
        List<JsonError> errors = new ArrayList<>();
  
        // Validaciones y reglas de negocio
        if (category.getCategoryId().equals(null) || category.getName().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","Id y nombre son obligatorios. "));
        }
        
        if (category.getCategoryId() < 0){
            errors.add(new JsonError("400", "BAD_REQUEST","El id de categoria no puede ser negativo. "));
        }

        if(!Utilities.isNumeric(category.getCategoryId().toString())){
            errors.add(new JsonError("400", "BAD_REQUEST","El id debe contener sólo dígitos "));
        }
        
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        } 
        this.notificar();
        return String.valueOf(repo.editC(id, category));
    }
    
    public synchronized String deleteCategory(Long id){
        List<JsonError> errors = new ArrayList<>();
        
        Category category = repo.findByIdC(id);
        
        // Validaciones y reglas de negocio
        if (category.equals(null)) {
           errors.add(new JsonError("400", "BAD_REQUEST","Categoria no encontrada. "));
        }
        
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        } 
        this.notificar();
        return String.valueOf(repo.deleteC(category.getCategoryId()));
    }
    
    public synchronized List<Category> findAllCategories(){
        List<Category> aux = repo.findAllC();
        
        if(!aux.isEmpty()){
            return aux;
        }
        return null;
    }
   
}
