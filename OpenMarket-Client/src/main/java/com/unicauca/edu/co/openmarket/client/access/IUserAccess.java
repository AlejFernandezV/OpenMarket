
package com.unicauca.edu.co.openmarket.client.access;

import com.unicauca.edu.co.openmarket.commons.domain.User;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IUserAccess {
    boolean save(User newUser) throws Exception;
    
    boolean edit(String login, User user) throws Exception;
    
    boolean delete(String login) throws Exception;
    
    User findByName (String name) throws Exception;
    
    User finByLogin(String login) throws Exception;
    
    List<User> findAll() throws Exception;
}
