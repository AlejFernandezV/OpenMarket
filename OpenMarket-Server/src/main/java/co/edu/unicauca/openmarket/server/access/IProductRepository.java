package co.edu.unicauca.openmarket.server.access;

import com.unicauca.edu.co.openmarket.commons.domain.Product;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IProductRepository {
    boolean save(Product newProduct);
    
    boolean edit(Long id, Product product);
    
    boolean delete(Long id);

    Product findById(Long id);
    
    Product findByName (String name);
    
    List<Product> findByDescription (String description);
    
    List<Product> findProductsByCategorie(String nameCategorie);
    
    List<Product> findAll();
}
