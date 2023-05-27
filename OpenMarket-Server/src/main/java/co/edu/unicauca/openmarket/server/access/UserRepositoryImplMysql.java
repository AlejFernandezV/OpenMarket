
package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.Product;
import com.unicauca.edu.co.openmarket.commons.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reloj.frameworkobsobs.Observado;

/**
 *
 * @author Alejandro
 */
public class UserRepositoryImplMysql extends Observado implements IUserRepository {
    
    private Connection conn;

    public UserRepositoryImplMysql() {
        initDatabase();
    }
    
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	login text PRIMARY KEY AUTOINCREMENT,\n"
                + "	username text NOT NULL,\n"
                + "	password text NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./myDatabase.db"; //Para Linux/Mac
        //String url = "jdbc:sqlite:C:/sqlite/db/myDatabase.db"; //Para Windows
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    @Override
    public boolean save(User newUser) {
        try {
            //Validate product
            if (newUser == null || newUser.getUsername().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO users ( login, username, password ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getLogin());
            pstmt.setString(2, newUser.getUsername());
            pstmt.setString(3, newUser.getPassword());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean edit(String login, User user) {
        try {
            //Validate product
            if (login.isEmpty() || user == null) {
                return false;
            }
            //this.connect();
            
            //TO DO CAMBIAR CONSULTA
            String sql = "UPDATE  users "
                    + "SET login=?, password=? "
                    + "WHERE login = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            /*
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setLong(3, id);
            */

            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String login) {
        try {
            //Validate product
            if (login.isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM users "
                    + "WHERE login = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, login);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User findByName(String Username) {
         try {

            String sql = "SELECT * FROM users  "
                    + "WHERE username LIKE ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Username);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                User user = new User();
                user.setLogin(res.getString("login"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password")); //CAMBIO
                return user;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User finByLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {

            String sql = "SELECT * FROM users";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                User user = new User();
                user.setLogin(res.getString("login"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                //newProduct.getCategory().setCategoryId(rs.getLong("fk_categoryId"));    //CAMBIO

                users.add(user);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
}
