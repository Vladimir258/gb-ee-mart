package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EntityManagerProductDao implements Dao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public String findNameById(Long id) {
        TypedQuery<String> nameQuery = entityManager.createNamedQuery("Product.findNameById", String.class);
        nameQuery.setParameter("id", id);
        return nameQuery.getSingleResult();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> nameQuery = entityManager.createNamedQuery("Product.findById", Product.class);
        nameQuery.setParameter("id", id);
        return nameQuery.getSingleResult();
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product save(Product product) {
        if(product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    @Override
    public void deleteById(Long id) {
        Product product = new Product();
        product.setId(id);
        delete(product);
    }

    public void delete(Product product) {
        Product mergeProduct = entityManager.merge(product);
        entityManager.remove(mergeProduct);
    }
}
