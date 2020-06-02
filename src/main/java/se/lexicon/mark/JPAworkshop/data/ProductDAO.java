package se.lexicon.mark.JPAworkshop.data;

import se.lexicon.mark.JPAworkshop.entity.Product;

import java.util.Collection;

public interface ProductDAO {

    Product create(Product product);
    Product findById(int productId);
    Collection<Product>findAll();
    Collection<Product>findByName(String productName);
    Product update(Product product);
    boolean delete(Product product);

}