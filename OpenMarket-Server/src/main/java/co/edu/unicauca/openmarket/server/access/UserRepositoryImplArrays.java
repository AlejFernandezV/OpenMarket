package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.User;
import java.util.ArrayList;
import java.util.List;
import reloj.frameworkobsobs.Observado;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alejandro
 */
public class UserRepositoryImplArrays extends Observado implements IUserRepository {
    /**
     * Array List de usuarios
     */
    private static List<User> users;

    public UserRepositoryImplArrays() {
        users = new ArrayList<>();
        if (users.size() == 0){
            inicializar();
        }
    }

    public void inicializar() {
        
    }
    
    @Override
    /**
    * Agrega un usuario en el arreglo
    *
    * @param neUser nuevo objeto usuario que se agregará
    * @return true si se agregó con éxito, en caso contrario false.
    */
    public boolean save(User newUser) {
        if(!newUser.equals(null)){
            users.add(newUser);
            this.notificar();
            return true;
        }
        return false;
    }

    /**
    * Edita un usuario en el arreglo
    * 
    * @param login Username del usuario a editar
    * @param product objeto user ya editado
    * @return true si se editó con éxito, en caso contrario false.
    */
    public boolean edit(String login, User user) {
        for(int i=0; i < users.size(); i++){
            if(users.get(i).getLogin().equals(login)){
                users.set(i, user);
                this.notificar();
                return true;
            }
        }
        return false;
    }

    /**
    * Elimina un usuario del arreglo
    *
    * @param login login del usuario que se eliminará del arreglo
    * @return true si se elimina con éxito, en caso contrario false.
    */
    public boolean delete(String login) {
        for(int i=0; i < users.size(); i++){
            if(users.get(i).getLogin().equals(login)){
                users.remove(i);
                this.notificar();
                return true;
            }
        }
        return false;
    }

    @Override
    /**
    * Encuentra un producto por Id en el arreglo
    *
    * @param name Nombre del usuario que se encontrará del arreglo
    * @return Objeto user encontrado.
    */
    public User findByName(String name) {
        for(User p: users){
            if(p.getUsername().equals(name)){
                return p;
            }
        }
        return null;
    }  
    
    @Override
    /**
    * Encuentra un usuario por su login en el arreglo
    *
    * @param login del usuario que se encontrará del arreglo
    * @return Objeto user encontrado.
    */
    public User finByLogin(String login) {
        for(User p: users){
            if(p.getLogin().equals(login)){
                return p;
            }
        }
        return null;
    }

    @Override
    /**
    * Encuentra todas los usuarios del arreglo.
    *
    * @return El arreglo de los usuarios
    */
    public List<User> findAll() {
        return users;
    }
}