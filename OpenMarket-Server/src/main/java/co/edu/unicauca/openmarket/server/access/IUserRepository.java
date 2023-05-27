
package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.User;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IUserRepository {
    boolean save(User newUser);
    
    boolean edit(String login, User user);
    
    boolean delete(String login);
    
    User findByName (String name);
    
    User finByLogin(String login);
    
    List<User> findAll();
}
