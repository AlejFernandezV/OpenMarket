/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.commands;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unicauca.edu.co.openmarket.client.access.UserAccessImplSockets;
import com.unicauca.edu.co.openmarket.commons.domain.User;

/**
 *
 * @author Personal
 */
public class OMAddUserCommand extends OMCommand {

    private User uU;
    private UserAccessImplSockets uA;
    boolean result=false;
    public OMAddUserCommand(User uU, UserAccessImplSockets uA){
        this.uU = uU;
        this.uA = uA;
    }
    
    
    @Override
    public void make() {
        try {
            result = uA.save(uU);
        } catch (Exception ex) {
            Logger.getLogger(OMAddUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unmake() {
        List<User> users = null;
        try {
            users = uA.findAll();
        } catch (Exception ex) {
            Logger.getLogger(OMAddUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (User eachU : users) {
            if(eachU.getUsername().equals(uU.getUsername())){
                try {
                    result = uA.delete(eachU.getLogin());
                } catch (Exception ex) {
                    Logger.getLogger(OMAddUserCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public boolean result(){
        return result;
    }
    
}
