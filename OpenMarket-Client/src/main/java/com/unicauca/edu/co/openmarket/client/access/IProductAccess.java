package com.unicauca.edu.co.openmarket.client.access;

import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.List;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public interface IProductAccess {

    boolean save(Product newProduct) throws Exception;
    
    boolean edit(Long id, Product product) throws Exception;
    
    boolean delete(Long id) throws Exception;

    Product findById(Long id) throws Exception;
    
    Product findByName (String name) throws Exception;
    
    List<Product> findByDescription (String description) throws Exception;
    
    List<Product> findProductsByCategorie(String nameCategorie) throws Exception;
    
    List<Product> findAll() throws Exception;
}
