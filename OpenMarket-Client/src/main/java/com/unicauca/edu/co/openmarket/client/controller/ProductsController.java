
package com.unicauca.edu.co.openmarket.client.controller;

import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.commands.OMAddProductCommand;
import com.unicauca.edu.co.openmarket.client.commands.OMInvoker;
import com.unicauca.edu.co.openmarket.commons.domain.Product;

/**
 *
 * @author Alejandro
 */
public class ProductsController {
    private ProductAccessImplSockets productAccess;
    private OMInvoker ominvoker;

    public ProductsController(ProductAccessImplSockets productService) {
        this.productAccess = productService;
        this.ominvoker = new OMInvoker();
    }
    
    public ProductAccessImplSockets getProductService() {
        return productAccess;
    }

    public void setProductService(ProductAccessImplSockets productService) {
        this.productAccess = productService;
    }

    public OMInvoker getOminvoker() {
        return ominvoker;
    }

    public void setOminvoker(OMInvoker ominvoker) {
        this.ominvoker = ominvoker;
    }

    public boolean addProduct(String name, String description) {
        Product product = new Product(0L,name, description, 0);
        OMAddProductCommand comm = new OMAddProductCommand(product, productAccess);
        ominvoker.addCommand(comm);
        ominvoker.execute(); 
        
        return comm.result();
    }

    public boolean editProduct(String id, String name, String description) {
        if (id.equals("")) {
            return false;
        }
        
        Long productId = Long.parseLong(id);
        Product prod = new Product();
        prod.setName(name);
        prod.setDescription(description);

        return productAccess.edit(productId, prod);
    }
    
    public boolean deleteProduct(String id) throws Exception{
        Long productId = Long.parseLong(id);
        return productAccess.delete(productId);
    }
}
