/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.commands;


import com.unicauca.edu.co.openmarket.client.access.ProductAccessImplSockets;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahurtado
 */
public class OMAddProductCommand extends OMCommand {

    private Product pP;
    private ProductAccessImplSockets pA;
    boolean result=false;
    public OMAddProductCommand(Product pP, ProductAccessImplSockets pA){
        this.pP = pP;
        this.pA = pA;
    }
    
    
    @Override
    public void make() {
        try {
            result = pA.save(pP);
        } catch (Exception ex) {
            Logger.getLogger(OMAddProductCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unmake() {
        List<Product> products = null;
        try {
            products = pA.findAll();
        } catch (Exception ex) {
            Logger.getLogger(OMAddProductCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Product each: products){
            if(each.getName().equals(pP.getName())){
                try {
                    result = pA.delete(each.getProductId());
                } catch (Exception ex) {
                    Logger.getLogger(OMAddProductCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public boolean result(){
        return result;
    }
    
}
