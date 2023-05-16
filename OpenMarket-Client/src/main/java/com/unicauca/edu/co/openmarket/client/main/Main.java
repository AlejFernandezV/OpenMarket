
package com.unicauca.edu.co.openmarket.client.main;

import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
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
        instance.setVisible(true);
        GUIProductsFind instance2 = new GUIProductsFind(null,false, productAccess);
        instance2.setVisible(true);
        productAccess.addObservador(instance2);
    }
    
}
