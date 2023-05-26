/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.access;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicauca.edu.co.openmarket.client.infra.OpenMarketSocket;
import com.unicauca.edu.co.openmarket.commons.domain.Category;
import com.unicauca.edu.co.openmarket.commons.infra.JsonError;
import com.unicauca.edu.co.openmarket.commons.infra.Protocol;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reloj.frameworkobsobs.Observado;

/**
 *
 * @author Personal
 */
public class CategoryAccessImplSockets extends Observado implements ICategoryAccess {
   
     /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private OpenMarketSocket mySocket;

    public CategoryAccessImplSockets() {
        mySocket = new OpenMarketSocket();
    }

    @Override
    public boolean saveC(Category newCategory) throws Exception  {
        String jsonResponse = null;
        String requestJson = doSaveCategoryRequestJSON(newCategory);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            return false;
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");            
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                this.notificar();
                return true;
            }
        }
    }

    @Override
    public boolean editC(Long categoryId, Category category) throws Exception {
        String jsonResponse = null;
        String requestJson = doEditCategoryRequestJSON(categoryId, category);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            return false;
        }
        if (jsonResponse == null) {
            return false;
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return false;
            } else {
                this.notificar();
                return true;
            }
        }
    }

    @Override
    public boolean deleteC(Long CategoryId) throws Exception {
        String jsonResponse = null;
        String requestJson = doDeleteCategoryRequestJSON(CategoryId);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            throw new Exception("No hubo conexión con el servidor");
        }
        if (jsonResponse == null) {
            return false;
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                this.notificar();
                return true;
            }
        }
    }

    @Override
    public Category findByIdC(Long id) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindIdCategoryRequestJSON(id);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró la categoría
                Category category = jsonToCategory(jsonResponse);
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return category;
            }
        }
    }

    @Override
    public Category findByNameC(String name) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindNameCategoryRequestJSON(name);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró la categoría
                Category category = jsonToCategory(jsonResponse);
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return category;
            }
        }
    }

    @Override
    public List<Category> findAllC() throws Exception {
        String jsonResponse = null;
        String requestJson = doFindAllCategoryRequestJson();
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(CategoryAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                Type type = new TypeToken<List<Category>>() {}.getType();
                List<Category> categories = new Gson().fromJson(jsonResponse, type);
                return categories;
            }
        }
    }


    private String doSaveCategoryRequestJSON(Category category){
        
        Protocol protocol = new Protocol();
        protocol.setResource("category");
        protocol.setAction("post");
        protocol.addParameter("id", category.getCategoryId().toString());
        protocol.addParameter("name", category.getName());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doEditCategoryRequestJSON(Long categoryId, Category category){
        
        Protocol protocol = new Protocol();
        protocol.setResource("category");
        protocol.setAction("put");
        protocol.addParameter("id", category.getCategoryId().toString());
        protocol.addParameter("name", category.getName());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doDeleteCategoryRequestJSON(Long categoryId){
        Protocol protocol = new Protocol();
        protocol.setResource("category");
        protocol.setAction("delete");
        protocol.addParameter("id", categoryId.toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doFindAllCategoryRequestJson(){
        Protocol protocol = new Protocol();
        protocol.setResource("category");
        protocol.setAction("getall");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doFindIdCategoryRequestJSON(Long categoryId){
        Protocol protocol = new Protocol();
        protocol.setResource("category");
        protocol.setAction("get");
        protocol.addParameter("id", categoryId.toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doFindNameCategoryRequestJSON(String name){

        Protocol protocol = new Protocol();
        protocol.setResource("category");
        protocol.setAction("get");
        protocol.addParameter("id", name);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }
    
    /**
     * Convierte jsonCustomer, proveniente del server socket, de json a un
     * objeto Customer
     *
     * @param jsonCategory objeto categoria en formato json
     */
    private Category jsonToCategory(String jsonCustomer) {

        Gson gson = new Gson();
        Category customer = gson.fromJson(jsonCustomer, Category.class);
        return customer;

    }
}
