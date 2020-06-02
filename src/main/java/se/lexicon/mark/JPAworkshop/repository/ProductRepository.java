package se.lexicon.mark.JPAworkshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mark.JPAworkshop.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByNameIgnoreCase(String name);
}
