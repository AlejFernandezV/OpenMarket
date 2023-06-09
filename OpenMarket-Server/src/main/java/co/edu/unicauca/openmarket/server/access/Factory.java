/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.access;

import co.edu.unicauca.openmarket.server.access.user.UserRepositoryImplMysql;
import co.edu.unicauca.openmarket.server.access.user.UserRepositoryImplArrays;
import co.edu.unicauca.openmarket.server.access.user.IUserRepository;
import co.edu.unicauca.openmarket.server.access.product.ProductRepositoryImplMysql;
import co.edu.unicauca.openmarket.server.access.product.ProductRepositoryImplArrays;
import co.edu.unicauca.openmarket.server.access.product.IProductRepository;
import co.edu.unicauca.openmarket.server.access.category.CategoryRepositoryImplMysql;
import co.edu.unicauca.openmarket.server.access.category.ICategoryRepository;
import co.edu.unicauca.openmarket.server.access.category.CategoryRepositoryImplArrays;
import co.unicauca.strategyserver.helpers.Utilities;

/**
 *
 * @author Alejandro
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
     * Método que crea una instancia concreta de la jerarquia
     * IProductRepository
     *
     * @return una clase hija de la abstracción IRepositorioProductos
     */
    public IProductRepository getProductRepository() {
        String type = Utilities.loadProperty("product.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IProductRepository result = null;

        switch (type) {
            case "default":
                result = new ProductRepositoryImplArrays();
                break;
            case "mysql":
                result = new ProductRepositoryImplMysql();
                break;
        }

        return result;
    }
    
    /**
     * Método que crea una instancia concreta de la jerarquia
     * ICategoryRepository
     *
     * @return una clase hija de la abstracción IRepositorioCategorias
     */
    public ICategoryRepository getCategoryRepository() {
        String type = Utilities.loadProperty("category.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        ICategoryRepository result = null;

        switch (type) {
            case "default":
                result = new CategoryRepositoryImplArrays();
                break;
            case "mysql":
                result = new CategoryRepositoryImplMysql();
                break;
        }

        return result;
    }
    
    /**
     * Método que crea una instancia concreta de la jerarquia
     * IUserRepository
     *
     * @return una clase hija de la abstracción IUserRepository
     */
    public IUserRepository getUserRepository() {
        String type = Utilities.loadProperty("user.repository");
        if (type.isEmpty()) {
            type = "default";
        }
        IUserRepository result = null;

        switch (type) {
            case "default":
                result = new UserRepositoryImplArrays();
                break;
            case "mysql":
                result = new UserRepositoryImplMysql();
                break;
        }

        return result;
    }
}
