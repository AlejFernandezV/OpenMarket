
package com.unicauca.edu.co.openmarket.client.main;

import com.unicauca.edu.co.openmarket.client.access.CategoryAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.presentation.GUICategories;
import com.unicauca.edu.co.openmarket.client.presentation.GUICategoriesFind;
import com.unicauca.edu.co.openmarket.client.presentation.GUIProducts;
import com.unicauca.edu.co.openmarket.client.presentation.GUIProductsFind;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        //IProductAccess access = Factory.getInstance().getProductService();
        ProductAccessImplSockets productAccess = new ProductAccessImplSockets();
        GUIProducts instance = new GUIProducts();
        instance.setProductAccess(productAccess);
        instance.setVisible(true);
        GUIProductsFind instance2 = new GUIProductsFind(null,false, productAccess);
        productAccess.addObservador(instance2);
        instance2.setVisible(true);
        
        CategoryAccessImplSockets categoryAccess = new CategoryAccessImplSockets();
        GUICategories instancec = new GUICategories();
        instancec.setCategoryAccess(categoryAccess);
        instancec.setVisible(true);
        GUICategoriesFind instance3 = new GUICategoriesFind(null,false, categoryAccess);
        categoryAccess.addObservador(instance2);
        instance3.setVisible(true);
    }
    
}
