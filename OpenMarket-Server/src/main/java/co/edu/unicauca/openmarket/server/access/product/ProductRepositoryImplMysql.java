/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.server.access.product;

import com.unicauca.edu.co.openmarket.commons.domain.Product;
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

/**
 *
 * @author Alejandro
 */
public class ProductRepositoryImplMysql implements IProductRepository{
    private Connection conn;

    public ProductRepositoryImplMysql() {
        initDatabase();
    }

    @Override
    public boolean save(Product newProduct) {

        try {
            //Validate product
            if (newProduct == null || newProduct.getName().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO products ( name, description ) "
                    + "VALUES ( ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newProduct.getName());
            pstmt.setString(2, newProduct.getDescription());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT * FROM products";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));
                //newProduct.getCategory().setCategoryId(rs.getLong("fk_categoryId"));    //CAMBIO

                products.add(newProduct);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS products (\n"
                + "	productId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	description text NULL\n"
                //+ "     fk_categoryId integer NOT NULL,"                                //CAMBIO
                //+ "     FOREIGN KEY(fk_categoryId) REFERENCES categories(categoryId)"   //CAMBIO
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
    public boolean edit(Long id, Product product) {
        try {
            //Validate product
            if (id <= 0 || product == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  products "
                    + "SET name=?, description=? "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        try {
            //Validate product
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM products "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product findById(Long id) {
        try {

            String sql = "SELECT * FROM products  "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Product prod = new Product();
                prod.setProductId(res.getLong("productId"));
                prod.setName(res.getString("name"));
                prod.setDescription(res.getString("description"));
                return prod;
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
    public Product findByName (String name){
        try {

            String sql = "SELECT * FROM products  "
                    + "WHERE productName LIKE ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Product prod = new Product();
                prod.setProductId(res.getLong("productId"));
                prod.setName(res.getString("name"));
                prod.setDescription(res.getString("description"));
                prod.getCategory().setCategoryId(res.getLong("fk_categoryId")); //CAMBIO
                return prod;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    //CAMBIO  PENDIENTE DE IMPLEMENTAR EN LA VISTA
    @Override
    public List<Product> findProductsByCategorie(String nameCategorie) {
        List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT productId, name, description FROM products  "
                    + "INNER JOIN categories"
                    + "ON products.fk_categoryId"
                    + "WHERE categories.name LIKE ?";
            //this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nameCategorie);
            
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));
                //newProduct.getCategory().setCategoryId(rs.getLong("fk_categoryId"));    //CAMBIO

                products.add(newProduct);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public List<Product> findByDescription(String description) {
        List<Product> products = new ArrayList<>();
        try {

            String sql = "SELECT productId, name, description FROM products  "
                    + "WHERE description LIKE ?";
            //this.connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, description);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product newProduct = new Product();
                newProduct.setProductId(rs.getLong("productId"));
                newProduct.setName(rs.getString("name"));
                newProduct.setDescription(rs.getString("description"));
                //newProduct.getCategory().setCategoryId(rs.getLong("fk_categoryId"));    //CAMBIO

                products.add(newProduct);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImplMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

}
