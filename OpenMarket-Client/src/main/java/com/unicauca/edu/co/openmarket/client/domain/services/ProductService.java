/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.domain.services;

import com.unicauca.edu.co.openmarket.client.access.IProductAccess;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Personal
 */
public class ProductService {
    private final IProductAccess access;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param access implementacion de tipo IProductAccess
     */
    public ProductService(IProductAccess access) {
        this.access = access;
    }

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     * @throws Exception
     */
    public boolean saveProduct(String name, String description) throws Exception {
        
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        
        //Validate product
        if (newProduct.getName().isBlank() ) {
            return false;
        }

        return access.save(newProduct);

    }

    public List<Product> findAllProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        products = access.findAll();

        return products;
    }
    
    public Product findProductById(Long id) throws Exception{
        return access.findById(id);
    }
    
    public Product findProductByName(String name) throws Exception{
        return access.findByName(name);
    }
    
    public Product findProductByDescription(String description) throws Exception{
        return access.findByDescription(description);
    }
    
    public List<Product> findProductsByCategorie(String nameCategory) throws Exception{
        return access.findProductsByCategorie(nameCategory);
    }
    
    public boolean deleteProduct(Long id) throws Exception{
        return access.delete(id);
    }

    public boolean editProduct(Long productId, Product prod) throws Exception {
        
        //Validate product
        if (prod == null || prod.getName().isBlank() ) {
            return false;
        }
        return access.edit(productId, prod);
    }
}
