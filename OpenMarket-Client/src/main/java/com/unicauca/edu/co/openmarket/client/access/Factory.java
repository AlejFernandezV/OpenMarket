/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.access;

import com.unicauca.edu.co.openmarket.commons.infra.Utilities;

/**
 *
 * @author Personal
 */
public class Factory {
     private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IProductAccess getProductService() {

        IProductAccess result = null;
        String type = Utilities.loadProperty("product.service");

        switch (type) {
            case "default":
                result = new ProductAccessImplSockets();
                break;
        }

        return result;

    }
    
    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public ICategoryAccess getCategoryService() {

        ICategoryAccess result = null;
        String type = Utilities.loadProperty("category.service");

        switch (type) {
            case "default":
                result = new CategoryAccessImplSockets();
                break;
        }

        return result;

    }
}
