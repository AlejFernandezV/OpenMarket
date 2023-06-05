
package co.edu.unicauca.openmarket.server.domain.services;

import co.edu.unicauca.openmarket.server.access.user.IUserRepository;
import co.unicauca.strategyserver.helpers.JsonError;
import co.unicauca.strategyserver.helpers.Utilities;
import com.google.gson.Gson;
import com.unicauca.edu.co.openmarket.commons.domain.User;
import java.util.ArrayList;
import java.util.List;
import reloj.frameworkobsobs.Observado;

/**
 *
 * @author Alejandro
 */
public class UserService extends Observado{
    /**
     * Repositorio de clientes
     */
    IUserRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IUserRepository
     */
    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    /**
     * Buscar un usuario
     *
     * @param String login
     * @return objeto tipo User
     */
    public synchronized User findByLoginUser(String login) {
        return repo.finByLogin(login);
    }

     /**
     * Buscar un usuario
     *
     * @param name nombre
     * @return objeto tipo Product
     */
    public synchronized User findByNameUser(String name) {
        return repo.findByName(name);
    }

    /**
     * Crea un nuevo usuario. Aplica validaciones de negocio
     *
     * @param user cliente
     * @return devuelve la cadena "true" si fue creado, en caso contrario retornará errorsJson
     */
    public synchronized String createUser(User user) {
        List<JsonError> errors = new ArrayList<>();
  
        // Validaciones y reglas de negocio
        if (user.getLogin().equals(null) || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","Login, username y contraseña son obligatorios. "));
        }
        
        if (user.getLogin().isEmpty()){
            errors.add(new JsonError("400", "BAD_REQUEST","El login no puede estar vacío. "));
        }

        if(Utilities.isNumeric(user.getUsername())){
            errors.add(new JsonError("400", "BAD_REQUEST","El nombre del usuario NO debe contener  dígitos "));
        }
        
        // Que no esté repetido
        User userSearched = this.findByLoginUser(user.getLogin());
        if (userSearched != null){
            errors.add(new JsonError("400", "BAD_REQUEST","El usuario ya existe. "));
        }
        
       if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
       this.notificar();
       return String.valueOf(repo.save(user));
    }
    
    public synchronized String editUser(String login, User user){
        List<JsonError> errors = new ArrayList<>();
  
        // Validaciones y reglas de negocio
        if (user.getLogin().equals(null) || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","Login, username y contraseña son obligatorios. "));
        }
        
        if (user.getLogin().isEmpty()){
            errors.add(new JsonError("400", "BAD_REQUEST","El login no puede estar vacío. "));
        }

        if(Utilities.isNumeric(user.getUsername())){
            errors.add(new JsonError("400", "BAD_REQUEST","El nombre del usuario NO debe contener  dígitos "));
        }
        
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        } 
        this.notificar();
        return String.valueOf(repo.edit(login, user));
    }
    
    public synchronized String deleteUser(String login){
        List<JsonError> errors = new ArrayList<>();
        
        User user = repo.finByLogin(login);
        
        // Validaciones y reglas de negocio
        if (user.equals(null)) {
           errors.add(new JsonError("400", "BAD_REQUEST","Usuario no encontrado. "));
        }
        
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        } 
        this.notificar();
        return String.valueOf(repo.delete(user.getLogin()));
    }
    
    public synchronized List<User> findAllUsers(){
        List<User> aux = repo.findAll();
        
        if(!aux.isEmpty()){
            return aux;
        }
        return null;
    }

   
}
