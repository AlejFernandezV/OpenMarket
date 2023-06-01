/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.ArrayList;
import java.util.List;
import reloj.frameworkobsobs.Observado;

/**
 *
 * @author Alejandro
 */
public class ProductRepositoryImplArrays extends Observado implements IProductRepository{
    /**
     * Array List de productos
     */
    private static List<Product> products;

    public ProductRepositoryImplArrays() {
        products = new ArrayList<>();
        if (products.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        Product product1 = new Product();
        product1.setProductId(100L);
        product1.setName("Producto 100");
        product1.setDescription("Descripcion producto 100");
        
        Product product2 = new Product();
        product2.setProductId(200L);
        product2.setName("Producto 200");
        product2.setDescription("Descripcion producto 200");
        
        Product product3 = new Product();
        product3.setProductId(300L);
        product3.setName("Producto 300");
        product3.setDescription("Descripcion producto 300");
        
        Product product4 = new Product();
        product4.setProductId(400L);
        product4.setName("Producto 400");
        product4.setDescription("Descripcion producto 400");
        
        Product product5 = new Product();
        product5.setProductId(500L);
        product5.setName("Producto 500");
        product5.setDescription("Descripcion producto 500");
        
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
        if(!newProduct.equals(null)){
            products.add(newProduct);
            this.notificar();
            return true;
        }
        return false;
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
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getProductId().equals(id)){
                products.set(i, product);
                this.notificar();
                return true;
            }
        }
        return false;
    }

    @Override
    /**
    * Elimina un producto del arreglo
    *
    * @param id Id de la categoria que se eliminará del arreglo
    * @return true si se elimina con éxito, en caso contrario false.
    */
    public boolean delete(Long id) {
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getProductId().equals(id)){
                products.remove(i);
                this.notificar();
                return true;
            }
        }
        return false;
    }

    @Override
    /**
    * Encuentra un producto por Id en el arreglo
    *
    * @param id Id del producto que se encontrará del arreglo
    * @return Objeto categoria encontrado por el Id.
    */
    public Product findById(Long id) {
        for(Product p: products){
            if(p.getProductId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    /**
    * Encuentra un producto por nombre en el arreglo
    *
    * @param name Nombre del producto que se encontrará del arreglo
    * @return Objeto categoria encontrado por el nombre.
    */
    public Product findByName(String name) {
        for(Product p: products){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    
    @Override
    /**
    * Encuentra un producto por descripcion en el arreglo
    *
    * @param description del producto que se encontrará del arreglo
    * @return Objeto categoria encontrado por la descripción.
    */
    public List<Product> findByDescription(String description) {
        List<Product> productsFound = new ArrayList<>();
        for(Product p: products){
            if(p.getDescription().contains(description)){
                productsFound.add(p);
            }
        }
        return productsFound;
    }
    
    @Override
    /**
    * Encuentra los productos con la misma categoria en el arreglo
    *
    * @param nameCategorie del producto que se encontrará del arreglo
    * @return Lista de los arreglos con la categoria buscada.
    */
    public List<Product> findProductsByCategorie(String nameCategorie) {
        List<Product> productsFound = new ArrayList<>();
        for(Product p: products){
            if(p.getCategory().getName().equals(nameCategorie)){
                productsFound.add(p);
            }
        }
        return productsFound;
    }

    @Override
    /**
    * Encuentra todas los productos del arreglo.
    *
    * @return El arreglo de los productos
    */
    public List<Product> findAll() {
        return products;
    }
}
