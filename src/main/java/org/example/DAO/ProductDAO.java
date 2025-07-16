package org.example.DAO;

import org.example.Entities.Product;

import java.util.List;

public class ProductDAO extends BaseDAO<Product>{
    public ProductDAO() {
        super(Product.class);
    }
}
