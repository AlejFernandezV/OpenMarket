/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.infra.tcpip;

import co.edu.unicauca.openmarket.server.domain.services.CategoryService;
import co.edu.unicauca.openmarket.server.domain.services.ProductService;
import co.edu.unicauca.openmarket.server.domain.services.UserService;
import co.unicauca.strategyserver.helpers.JsonError;
import co.unicauca.strategyserver.infra.ServerHandler;
import com.google.gson.Gson;
import com.unicauca.edu.co.openmarket.commons.domain.Category;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import com.unicauca.edu.co.openmarket.commons.infra.Protocol;
import java.util.ArrayList;
import java.util.List;
import reloj.frameworkobsobs.Observador;

/**
 *
 * @author Alejandro
 */
public class OpenMarketHandler extends ServerHandler implements Observador{
     /**
     * Servicio de clientes
     */
    private static ProductService serviceP;
    private static CategoryService serviceC;
    private static UserService serviceU;

    public OpenMarketHandler() {
    }

     /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    @Override
    public String processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();  
        Protocol protocolRequest;
        protocolRequest = gson.fromJson(requestJson, Protocol.class);
        String response="";
        
        switch (protocolRequest.getResource()) {
            case "product":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    response = processGetProduct(protocolRequest);
                }
                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    response = processPostProduct(protocolRequest);
                }
                if(protocolRequest.getAction().equals("getall")){
                    response = processGetProductAll();
                }
                if(protocolRequest.getAction().equals("put")){
                    response = processPutProduct(protocolRequest);
                }
                if(protocolRequest.getAction().equals("delete")){
                    response = processDeleteProduct(protocolRequest);
                }
                break;
                
            case "category":
                if (protocolRequest.getAction().equals("get")) {
                    response = processGetCategory(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {   
                    response = processPostCategory(protocolRequest);
                }
                if(protocolRequest.getAction().equals("getall")){
                    response = processGetCategoryAll();
                }
                if(protocolRequest.getAction().equals("put")){
                    response = processPutCategory(protocolRequest);
                }
                if(protocolRequest.getAction().equals("delete")){
                    response = processDeleteCategory(protocolRequest);
                }
                break;
        }
        this.actualizar();
        return response;

    }

    /**
     * Procesa la solicitud de consultar un producto
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private String processGetProduct(Protocol protocolRequest) {
        String parameter = protocolRequest.getParameters().get(0).getName();
        String value = protocolRequest.getParameters().get(0).getValue();
        Product product = null;
        switch(parameter){
            case "id":
                product = serviceP.findByIdProduct(Long.parseLong(value));
                break;
            case "name":
                product = serviceP.findByNameProduct(value);
                break;
        }
        if (product == null) {
            String errorJson = generateNotFoundProductErrorJson();
            return errorJson;
        } else {
            return objectToJSON(product);
        }
    }

    private String processGetCategory(Protocol protocolRequest) {
        String parameter = protocolRequest.getParameters().get(0).getName();
        String value = protocolRequest.getParameters().get(0).getValue();
        Category category = null;
        switch(parameter){
            case "id":
                category = serviceC.findByIdCategory(Long.parseLong(value));
                break;
            case "name":
                category = serviceC.findByNameCategory(value);
                break;
        }
        if (category == null) {
            String errorJson = generateNotFoundCategoryErrorJson();
            return errorJson;
        } else {
            return objectToJSON(category);
        }
    }
    /**
     * Procesa la solicitud de agregar un producto
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private String processPostProduct(Protocol protocolRequest) {
        Product product = new Product();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        product.setProductId(Long.parseLong(protocolRequest.getParameters().get(0).getValue()));
        product.setName(protocolRequest.getParameters().get(1).getValue());
        product.setDescription(protocolRequest.getParameters().get(2).getValue());

        String response = getServiceP().createProduct(product);
        
        return response;
    }
    
    private String processPostCategory(Protocol protocolRequest) {
        Category category = new Category();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        category.setCategoryId(Long.parseLong(protocolRequest.getParameters().get(0).getValue()));
        category.setName(protocolRequest.getParameters().get(1).getValue());

        String response = getServiceC().createCategory(category);
        
        return response;
    }
    
     private String processPutProduct(Protocol protocolRequest) {
        
        String id = protocolRequest.getParameters().get(0).getValue();
        String name = protocolRequest.getParameters().get(1).getValue();
        String description = protocolRequest.getParameters().get(2).getValue();
        Product product = serviceP.findByIdProduct(Long.parseLong(id));
        
        product.setName(name);
        product.setDescription(description);
        
        String response = serviceP.editProduct(Long.parseLong(id), product);
        
        if (product == null) {
            String errorJson = generateNotFoundProductErrorJson();
            return errorJson;
        } else {
            return objectToJSON(response);
        }
    }
     
    private String processPutCategory(Protocol protocolRequest) {
        
        String id = protocolRequest.getParameters().get(0).getValue();
        String name = protocolRequest.getParameters().get(1).getValue();
        Category category = serviceC.findByIdCategory(Long.parseLong(id));
        
        category.setName(name);
        
        String response = serviceC.editCategory(Long.parseLong(id), category);
        
        if (category == null) {
            String errorJson = generateNotFoundCategoryErrorJson();
            return errorJson;
        } else {
            return objectToJSON(response);
        }
    }
    
    private String processDeleteProduct(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue(); 
        
        String response = serviceP.deleteProduct(Long.parseLong(id));
        
        if (response.isEmpty()) {
            String errorJson = generateNotFoundProductErrorJson();
            return errorJson;
        } else {
            return objectToJSON(response);
        }
    }
    
    private String processDeleteCategory(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue(); 
        
        String response = serviceC.deleteCategory(Long.parseLong(id));
        
        if (response.isEmpty()) {
            String errorJson = generateNotFoundCategoryErrorJson();
            return errorJson;
        } else {
            return objectToJSON(response);
        }
    }
    
    private String processGetProductAll() {
        List<Product> products;
        products = serviceP.findAllProducts();
        return objectToJSON(products);
    }
    
    private String processGetCategoryAll() {
        List<Category> categories;
        categories = serviceC.findAllCategories();
        return objectToJSON(categories);
    }

    /**
     * Genera un ErrorJson de producto no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundProductErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Producto no encontrado. Id no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }


    /**
     * Genera un ErrorJson de producto no encontrado
     *
     * @return error en formato json
     */
    private String generateNotFoundCategoryErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("Categoria no encontrada. Id no existe");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

    /**
     * @return the product service 
     */
    public ProductService getServiceP() {
        return serviceP;
    }

    /**
     * @param service the product service to set
     */
    public void setServiceP(ProductService serviceP) {
        this.serviceP = serviceP;
    }
    
    /**
     * @return the category service 
     */
    public CategoryService getServiceC() {
        return serviceC;
    }

    /**
     * @param service the category service to set
     */
    public void setServiceC(CategoryService serviceC) {
        this.serviceC = serviceC;
    }
    
    //TO DO
    /*
        - PROCESAR LOS REQUEST PARA LOS USUARIOS
        - GETTER Y SETTER PARA EL SERVCICIO DE USUARIO
    */

    @Override
    public void actualizar() {
        serviceP.findAllProducts();
        serviceC.findAllCategories();
        serviceU.findAllUsers();
    }
}
