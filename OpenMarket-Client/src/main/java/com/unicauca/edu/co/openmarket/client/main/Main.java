
package com.unicauca.edu.co.openmarket.client.main;

import com.unicauca.edu.co.openmarket.client.access.CategoryAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.presentation.GUIBuyer;
import com.unicauca.edu.co.openmarket.client.presentation.GUIAnonymousUsers;
import com.unicauca.edu.co.openmarket.client.presentation.GUICategories;
import com.unicauca.edu.co.openmarket.client.presentation.GUICategoriesFind;
import com.unicauca.edu.co.openmarket.client.presentation.GUIProducts;
import com.unicauca.edu.co.openmarket.client.presentation.GUIProductsFind;
import com.unicauca.edu.co.openmarket.client.presentation.GUIRegistred;
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
        
        GUIAnonymousUsers gui = new GUIAnonymousUsers(productAccess);
        gui.setVisible(true);
        
        /*
        GUIProducts instance = new GUIProducts();
        instance.setProductAccess(productAccess);
        instance.setVisible(true);
        GUIProductsFind instance2 = new GUIProductsFind(null,false, productAccess);
        productAccess.addObservador(instance2);
        instance2.setVisible(true);
   
        CategoryAccessImplSockets categoryAccess = new CategoryAccessImplSockets();
        GUICategories instanceC = new GUICategories();
        instanceC.setCategoryAccess(categoryAccess);
        instanceC.setVisible(true);
        GUICategoriesFind instance3 = new GUICategoriesFind(null,false, categoryAccess);
        categoryAccess.addObservador(instance3);
        instance3.setVisible(true);
        */
        ProductAccessImplSockets buyerAcces = new ProductAccessImplSockets();
        GUIRegistred instanceB = new GUIRegistred();
        instanceB.setProductAccess(buyerAcces);
        instanceB.setVisible(true);
    }
    
}
