
package com.unicauca.edu.co.openmarket.client.main;

import com.unicauca.edu.co.openmarket.client.access.UserAccessImplSockets;
import com.unicauca.edu.co.openmarket.client.presentation.login.GUILogin;

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
        
        UserAccessImplSockets userAccess = new UserAccessImplSockets();
        
        GUILogin login = new GUILogin(userAccess);
        login.setVisible(true);
    }
    
}
