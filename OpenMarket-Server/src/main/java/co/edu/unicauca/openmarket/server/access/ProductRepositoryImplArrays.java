/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ProductRepositoryImplArrays implements IProductRepository{
    /**
     * Array List de productos
     */
    private static List<Product> products;

    public ProductRepositoryImplArrays() {
        if (products == null){
            products = new ArrayList();
        }
        if (products.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        Product product1 = new Product();
        product1.setProductId(1L);
        product1.setName("Producto 1");
        product1.setDescription("Descripcion producto 1");
        
        Product product2 = new Product();
        product2.setProductId(2L);
        product2.setName("Producto 2");
        product2.setDescription("Descripcion producto 2");
        
        Product product3 = new Product();
        product3.setProductId(3L);
        product3.setName("Producto 3");
        product3.setDescription("Descripcion producto 3");
        
        Product product4 = new Product();
        product4.setProductId(4L);
        product4.setName("Producto 4");
        product4.setDescription("Descripcion producto 4");
        
        Product product5 = new Product();
        product5.setProductId(5L);
        product5.setName("Producto 5");
        product5.setDescription("Descripcion producto 5");
        
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }
    
    @Override
    /**
    * Agrega un producto en el arreglo
    *
    * @param newProduct nuevo objeto producto que se agregará
    * @return true si se agregó con éxito, en caso contrario false.
    */
    public boolean save(Product newProduct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Edita una categoria en el arreglo
    * 
    * @param id Id del producto a editar
    * @param product objeto producto ya editado
    * @return true si se editó con éxito, en caso contrario false.
    */
    public boolean edit(Long id, Product product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Elimina un producto del arreglo
    *
    * @param id Id de la categoria que se eliminará del arreglo
    * @return true si se elimina con éxito, en caso contrario false.
    */
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Encuentra un producto por Id en el arreglo
    *
    * @param id Id del producto que se encontrará del arreglo
    * @return Objeto categoria encontrado por el Id.
    */
    public Product findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Encuentra un producto por Id en el arreglo
    *
    * @param name Nombre del producto que se encontrará del arreglo
    * @return Objeto categoria encontrado por el nombre.
    */
    public Product findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    //TO DO
    public List<Product> findProductsByCategorie(String nameCategorie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
    * Encuentra todas los productos del arreglo.
    *
    * @return El arreglo de los productos
    */
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
