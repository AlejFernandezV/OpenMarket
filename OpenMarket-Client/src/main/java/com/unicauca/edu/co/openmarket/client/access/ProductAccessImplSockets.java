
package com.unicauca.edu.co.openmarket.client.access;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicauca.edu.co.openmarket.client.infra.OpenMarketSocket;
import com.unicauca.edu.co.openmarket.commons.domain.Product;
import com.unicauca.edu.co.openmarket.commons.infra.JsonError;
import com.unicauca.edu.co.openmarket.commons.infra.Protocol;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reloj.frameworkobsobs.Observado;

/**
 * Servicio de Cliente. Permite hacer el CRUD de clientes solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class ProductAccessImplSockets extends Observado implements IProductAccess{
    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private OpenMarketSocket mySocket;

    public ProductAccessImplSockets() {
        mySocket = new OpenMarketSocket();
    }

    /**
     * Busca un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param id cedula del cliente
     * @return Objeto Customer
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    public Product findProduct(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindProductRequestJson(id);
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
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                Product product = jsonToProduct(jsonResponse);
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return product;
            }
        }

    }

    /**
     * Crea un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param product cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */
    public String createProduct(Product product) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateProductRequestJson(product);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return product.getProductId().toString();
            }

        }

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
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idCustomer identificación del cliente
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"customer","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String doFindProductRequestJson(String idCustomer) {

        Protocol protocol = new Protocol();
        protocol.setResource("customer");
        protocol.setAction("get");
        protocol.addParameter("id", idCustomer);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del customer para ser enviado por el
     * socket
     *
     * @param customer objeto customer
     * @return devulve algo como:
     * {"resource":"customer","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String doCreateProductRequestJson(Product product) {

        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("post");
        protocol.addParameter("id", product.getProductId().toString());
        protocol.addParameter("Name", product.getName());
        protocol.addParameter("Description", product.getDescription());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    /**
     * Convierte jsonCustomer, proveniente del server socket, de json a un
     * objeto Customer
     *
     * @param jsonCustomer objeto cliente en formato json
     */
    private Product jsonToProduct(String jsonCustomer) {

        Gson gson = new Gson();
        Product customer = gson.fromJson(jsonCustomer, Product.class);
        return customer;

    }

    @Override
    public boolean save(Product newProduct) throws Exception{
        String jsonResponse = null;
        String requestJson = doSaveProductRequestJSON(newProduct);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            return false;
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");            
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                return true;
            }
        }
    }

    @Override
    public boolean edit(Long id, Product product) {
       String jsonResponse = null;
        String requestJson = doEditProductRequestJSON(id, product);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
            return false;
        }
        if (jsonResponse == null) {
            return false;
        } else {
            if (jsonResponse.contains("error")) {
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return false;
            } else {
                return true;
            }
        } 
    }

    @Override
    public boolean delete(Long id) throws Exception {
        String jsonResponse = null;
        String requestJson = doDeleteProductRequestJSON(id);
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
                return true;
            }
        }
    }

    @Override
    public Product findById(Long id) throws Exception{
        String jsonResponse = null;
        String requestJson = doFindIdProductRequestJSON(id);
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
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró la categoría
                Product product = jsonToProduct(jsonResponse);
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return product;
            }
        }
    }

    @Override
    public Product findByName(String name) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindNameProductRequestJSON(name);
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
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró la categoría
                Product product = jsonToProduct(jsonResponse);
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return product;
            }
        }
    }

    @Override
    public List<Product> findProductsByCategorie(String nameCategorie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> findAll() throws Exception {
        String jsonResponse = null;
        String requestJson = doFindAllProductRequestJson();
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
                Logger.getLogger(ProductAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                Type type = new TypeToken<List<Product>>() {}.getType();
                List<Product> categories = new Gson().fromJson(jsonResponse, type);
                return categories;
            }
        }
    }

    private String doSaveProductRequestJSON(Product product){
        
        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("post");
        protocol.addParameter("id", product.getProductId().toString());
        protocol.addParameter("name", product.getName());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doEditProductRequestJSON(Long Id, Product product){
        
        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("put");
        protocol.addParameter("id", product.getProductId().toString());
        protocol.addParameter("name", product.getName());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doDeleteProductRequestJSON(Long productId){
        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("delete");
        protocol.addParameter("id", productId.toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doFindAllProductRequestJson(){
        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("getall");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doFindIdProductRequestJSON(Long productId){
        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("get");
        protocol.addParameter("id", productId.toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doFindNameProductRequestJSON(String name){

        Protocol protocol = new Protocol();
        protocol.setResource("product");
        protocol.setAction("get");
        protocol.addParameter("id", name);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }
}
