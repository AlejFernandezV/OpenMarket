
package com.unicauca.edu.co.openmarket.client.access;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicauca.edu.co.openmarket.client.infra.OpenMarketSocket;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import com.unicauca.edu.co.openmarket.commons.domain.User;
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
 * @author Alejandro
 */
public class UserAccessImplSockets extends Observado implements IUserAccess{
    
    private OpenMarketSocket mySocket;

    public UserAccessImplSockets() {
        mySocket = new OpenMarketSocket();
    }
    
    @Override
    public boolean save(User newUser) throws Exception{
        String jsonResponse = null;
        String requestJson = doSaveUserRequestJSON(newUser);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            return false;
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");            
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                this.notificar();
                return true;
            }
        }
    }

    @Override
    public boolean edit(String login, User user) throws Exception{
        String jsonResponse = null;
        String requestJson = doEditUserRequestJSON(login, user);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            return false;
        }
        if (jsonResponse == null) {
            return false;
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return false;
            } else {
                this.notificar();
                return true;
            }
        } 
    }

    @Override
    public boolean delete(String login) throws Exception{
        String jsonResponse = null;
        String requestJson = doDeleteUserRequestJSON(login);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            throw new Exception("No hubo conexión con el servidor");
        }
        if (jsonResponse == null) {
            return false;
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                this.notificar();
                return true;
            }
        }
    }

    @Override
    public User findByName(String name) throws Exception{
        String jsonResponse = null;
        String requestJson = doFindUserByUsernameRequestJSON(name);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el producto
                User user = jsonToUser(jsonResponse);
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return user;
            }
        }
    }

    @Override
    public User finByLogin(String login) throws Exception{
        String jsonResponse = null;
        String requestJson = doFindUserByLoginRequestJSON(login);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el user
                User user = jsonToUser(jsonResponse);
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return user;
            }
        }
    }

    @Override
    public List<User> findAll() throws Exception{
        String jsonResponse = null;
        String requestJson = doFindAllUserRequestJson();
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                Type type = new TypeToken<List<Product>>() {}.getType();
                List<User> users = new Gson().fromJson(jsonResponse, type);
                return users;
            }
        }
    }
    
    private String doSaveUserRequestJSON(User user){
        
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("post");
        protocol.addParameter("login", user.getLogin());
        protocol.addParameter("username", user.getUsername());
        protocol.addParameter("password", user.getPassword());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doEditUserRequestJSON(String login, User user){
        
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("put");
        protocol.addParameter("login", user.getLogin());
        protocol.addParameter("username", user.getUsername());
        protocol.addParameter("password", user.getPassword());
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doDeleteUserRequestJSON(String login){
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("delete");
        protocol.addParameter("login", login);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doFindAllUserRequestJson(){
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("getall");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }
    
    private String doFindUserByLoginRequestJSON(String login){
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("get");
        protocol.addParameter("login", login);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doFindUserByUsernameRequestJSON(String username){

        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("get");
        protocol.addParameter("name", username);

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
     * Convierte jsonUSer, proveniente del server socket, de json a un
     * objeto USer
     *
     * @param jsonUser objeto usuario en formato json
     */
    private User jsonToUser(String jsonUser) {

        Gson gson = new Gson();
        User user = gson.fromJson(jsonUser, User.class);
        return user;
    }
}
