package co.edu.unicauca.openmarket.server.access;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Alejandro
 */
public interface IProductRepository {
    boolean save(Product newProduct);
    
    boolean edit(Long id, Product product);
    
    boolean delete(Long id);

    Product findById(Long id);
    
    Product findByName (String name);
    
    List<Product> findProductsByCategorie(String nameCategorie);
    
    List<Product> findAll();
}
