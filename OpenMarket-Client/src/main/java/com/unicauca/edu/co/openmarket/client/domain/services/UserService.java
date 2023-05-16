
package com.unicauca.edu.co.openmarket.client.domain.services;

import com.unicauca.edu.co.openmarket.client.domain.User;
import com.unicauca.edu.co.openmarket.client.presentation.GUIProducts;

/**
 * Servicio de usuarios del sistema
 * @author Libardo, Julio
 */
public class UserService {
    /**
     * Autentica el usuario en el sistema
     * Por ahora no hace ninguna validación
     * @param login login de usuario
     * @param password contraseña
     * @return objeto User cuando la autenticación es exitosa
     */
    public User autenticacion(String login, String password) {
        if(login == "product"){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GUIProducts().setVisible(true);
                }
            });
        }
        return null;
    }
}
