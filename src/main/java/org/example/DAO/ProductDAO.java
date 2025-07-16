package org.example.DAO;

import org.example.Entities.Product;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAO extends BaseDAO<Product>{
    public ProductDAO() {
        super(Product.class);
    }

    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p", Product.class
        );
        return query.getResultList();
    }
}
