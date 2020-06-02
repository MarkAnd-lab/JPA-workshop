package se.lexicon.mark.JPAworkshop.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.mark.JPAworkshop.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Product create(Product product) {

        entityManager.persist(product);
        return product;
    }

    @Override
    public Product findById(int productId) {

        return entityManager.find(Product.class, productId);
    }

    @Override
    public Collection<Product> findAll() {

        Query query = entityManager.createQuery("SELECT p FROM Product p");

        return query.getResultList();
    }

    @Override
    public Collection<Product> findByName(String productName) {
        Query query = entityManager.createQuery("SELECT p FROM Product AS p WHERE p.name =?1");
        query.setParameter(1, productName);

        return query.getResultList();
    }

    @Override
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public boolean delete(Product product) {
        entityManager.remove(product);
        return true;
    }
}