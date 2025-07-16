package org.example.Services;

import org.example.DAO.ProductDAO;
import org.example.Entities.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public Product create(Product product) {
        return productDAO.save(product);
    }

    public Product getById(long id) {
        return productDAO.get(id);
    }

    public boolean deleteById(long id) {
        return productDAO.delete(id);
    }

    public Product update(Product product) {
        return productDAO.update(product);
    }
    public List<Product> getAll() {
        return productDAO.findAll();
    }
}
