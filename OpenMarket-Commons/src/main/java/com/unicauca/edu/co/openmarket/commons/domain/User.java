/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.commons.domain;

/**
 *
 * @author Alejandro
 */
public class User {
     /**
     *
     */
    private String login;
    /**
     *
     */
    private String password;
    /**
     * Nombres y apellidos completos
     */
    private String username;
    /**
     *
     */
    private enumRoleUser role;
    
    /*
    *   Constructor no parametrizado
    */
    public User(){
    }

    /**
     * Constructor que inicializa un usuario
     *
     * @param login nombre del usuario
     * @param password contraseña secreta
     * @param username nombre del usuario
     */
    public User(String login, String password, String username, enumRoleUser role) {
        this.login = login;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public enumRoleUser getRole() {
        return role;
    }
    
    public void setRole(enumRoleUser role) {    
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String contrasenia) {
        this.password = contrasenia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nombres) {
        this.username = nombres;
    }
}
