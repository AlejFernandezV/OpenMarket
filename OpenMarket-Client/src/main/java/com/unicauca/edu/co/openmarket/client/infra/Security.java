
package com.unicauca.edu.co.openmarket.client.infra;

import com.unicauca.edu.co.openmarket.commons.domain.User;

/**
 * Esta pendiente implementar esta clase. Tendra la responsabilidad de cosas
 * de seguridad, por ejemplo, almacenar el usuario autenticado
 * @author Libardo, Julio
 */
public class Security {
    public User usuario;   
    
    public boolean verifyPassword(char password[]){
        char contraVerdadera[] = usuario.getPassword().toCharArray();
        
        int cantIngresada = password.length;
        int cantVerdadera = contraVerdadera.length;
        
        if(cantIngresada != cantVerdadera){
            return false;
        }
        
        for(int i=0; i < cantVerdadera; i++){
            if(password[i]!=contraVerdadera[i]){
                return false;
            }
        }
        return true;
    }

    public  User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
    
    
}
